package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.http;

import com.fasterxml.jackson.core.JsonGenerator;
import org.json.JSONObject;
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

    @GetMapping("/sessions")
    public ResponseEntity<?> getAllSession(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");

        List<Session> sessions = sessionService.getAllSessionByUser(username);
        List<SessionResponse> sessionResponses = new ArrayList<>();

        sessions.forEach(session -> {
            sessionResponses.add(new SessionResponse(session));
        });

        return ResponseEntity.ok(new DataResponse(sessionResponses));
    }

    @GetMapping("/top/{limit}")
    public ResponseEntity<?> getTop(@PathVariable Integer limit) {
        return ResponseEntity.ok(sessionService.getTopUser(limit));
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> createSession(
            HttpServletRequest request,
            @RequestParam Integer turns) {

        String username = (String)request.getAttribute("username");

        Session session = new Session();
        session.setTurns(turns);

        sessionService.createSession(username, session);
        JSONObject data = new JSONObject();
        data.put("id", session.getId());
        data.put("turns", session.getTurns());

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

        SessionPlay sessionPlay = sessionService.getSessionPlay(username, id);
        JSONObject response = new JSONObject();

        Session session = sessionPlay.getSession();
        Integer remain = sessionPlay.getRemainTurn();

        if(session != null && remain > 0) {
            if(!(type >= 1 && type <= 3)) {
                response.put("error", "Wrong type");
                return ResponseEntity.ok("Wrong type");
            } else {
                Random random = new Random();
                Integer computer = random.nextInt(3) + 1;
                Integer result = checkWin(type, computer);

                SessionDetail sessionDetail = new SessionDetail(result, type, session);
                session.addSessionDetail(sessionDetail);

                sessionService.save(session);

                if(remain == 1) {
                    Integer generalResult = sessionService.generalResult(session);
                    if (generalResult == 0) {
                        session.setTurns(session.getTurns() + 1);
                        sessionService.save(session);
                        response.put("message", "General result is draw");
                    } else if (generalResult == 1){
                        response.put("message", "General result is winning");
                    } else {
                        response.put("message", "General result is losing");
                    }
                }

                response.put("result", getResultToString(result));
                return ResponseEntity.ok(response.toMap());
            }
        } else {
            response.put("error", "Session not found or session out of turn");
            return ResponseEntity.ok(response.toMap());
        }
    }

    private Integer checkWin(Integer player, Integer computer) {
        if(player == computer) {
            return 0;
        } else {
            Integer result = 0;
            if(player == 1) {
                if(computer == 2) {
                    result = -1;
                } else {
                    result = 1;
                }
            } else if(player == 2) {
                if(computer == 3) {
                    result = -1;
                } else {
                    result = 1;
                }
            } else {
                if(computer == 1) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
            return result;
        }
    }

    private String getResultToString(Integer result) {
        if(result == -1) {
            return "LOSE";
        } else if(result == 0) {
            return "DRAW";
        } else {
            return "WIN";
        }
    }
}
