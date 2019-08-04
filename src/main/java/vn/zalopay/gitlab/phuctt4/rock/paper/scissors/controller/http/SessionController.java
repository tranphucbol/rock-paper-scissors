package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.CreateSessionResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.DataResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.SessionResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        return ResponseEntity.ok(new DataResponse(sessionService.getTopUser(limit)));
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> createSession(HttpServletRequest request) {
        String username = (String)request.getAttribute("username");

        LOGGER.info("Request POST /sessions - {}", username);

        Session session = new Session();

        sessionService.createSession(username, session);
        return ResponseEntity.ok(new DataResponse(new CreateSessionResponse(session.getId())));
    }

    @PostMapping("/sessions/{id}")
    public ResponseEntity<?> playSession(
            HttpServletRequest request,
            @RequestParam Integer type,
            @PathVariable Long id
    ) {
        String username = (String)request.getAttribute("username");

        LOGGER.info("Request POST /sessions/{} - {} - type: {}", id, username, type);

        DataResponse dataResponse = sessionService.play(username, id, type);

        return ResponseEntity.ok(dataResponse);
    }
}
