package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.http;

import com.fasterxml.jackson.core.JsonGenerator;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.DataResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.SessionPlay;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.SessionResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/sessions")
    public ResponseEntity<?> getAllSession(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");

        LOGGER.info("Request GET /sessions - {}", username);

        List<Session> sessions = sessionService.getAllSessionByUser(username);
        List<SessionResponse> sessionResponses = new ArrayList<>();

        sessions.forEach(session -> {
            sessionResponses.add(new SessionResponse(session));
        });

        return ResponseEntity.ok(new DataResponse(sessionResponses));
    }

    @GetMapping("/top/{limit}")
    public ResponseEntity<?> getTop(@PathVariable Integer limit) {
        LOGGER.info("Request GET /top/{}", limit);
        return ResponseEntity.ok(sessionService.getTopUser(limit));
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> createSession(HttpServletRequest request) {
        String username = (String)request.getAttribute("username");

        LOGGER.info("Request POST /sessions - {}", username);

        Session session = new Session();

        sessionService.createSession(username, session);
        JSONObject data = new JSONObject();
        data.put("id", session.getId());

        JSONObject response = new JSONObject();
        response.put("data", data.toMap());
        return ResponseEntity.ok(response.toMap());
    }

    @PostMapping("/sessions/{id}")
    public ResponseEntity<?> playSession(
            HttpServletRequest request,
            @RequestParam Integer type,
            @PathVariable Long id
    ) {
        String username = (String)request.getAttribute("username");

        LOGGER.info("Request POST /sessions/{} - {} - type: ", id, username, type);

        Session session= sessionService.getSession(username, id);
        JSONObject response = new JSONObject();

        if(session != null) {
            if(!(type >= 1 && type <= 3)) {
                response.put("error", "Wrong type");
                LOGGER.error("Wrong type {}", type);
                return ResponseEntity.ok("Wrong type");
            } else {
                Random random = new Random();
                Integer computer = random.nextInt(3) + 1;
                Integer result = sessionService.checkWin(type, computer);

                SessionDetail sessionDetail = new SessionDetail(result, type, session);
                session.addSessionDetail(sessionDetail);

                sessionService.save(session);

                if(result == 1) {
                    sessionService.updateSessionCache(username, true);
                } else if (result == -1) {
                    sessionService.updateSessionCache(username, false);
                }

                response.put("result", sessionService.getResultToString(result));
                return ResponseEntity.ok(response.toMap());
            }
        } else {
            response.put("error", "Session not found or session out of turn");
            LOGGER.error("Session {} not found or session out of turn", id);
            return ResponseEntity.ok(response.toMap());
        }
    }
}
