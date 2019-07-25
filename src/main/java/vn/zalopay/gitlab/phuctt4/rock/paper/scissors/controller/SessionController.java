package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/sessions")
    public ResponseEntity<?> createSession(
            HttpServletRequest request,
            @RequestParam Integer turns) {

        String username = (String)request.getAttribute("username");

        Session session = new Session();
        session.setTurns(turns);

        sessionService.createSession(username, session);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", session.getId());
        jsonObject.put("turns", session.getTurns());
        return ResponseEntity.ok(jsonObject.toMap());
    }

    @PostMapping("/sessions/{id}")
    public ResponseEntity<?> playSession(
            HttpServletRequest request,
            @RequestParam Integer type,
            @PathVariable Long id
    ) {
        String username = (String)request.getAttribute("username");

        Session session = sessionService.getSession(username, id);
        if(session != null) {
            if(!(type >= 1 && type <= 3)) {
                return ResponseEntity.ok("Wrong type");
            } else {
                Random random = new Random();
                Integer computer = random.nextInt(3) + 1;
                Integer result = checkWin(type, computer);

                SessionDetail sessionDetail = new SessionDetail(result, type, session);
                session.addSessionDetail(sessionDetail);

                sessionService.save(session);
                return ResponseEntity.ok(getResultToString(result));
            }
        } else {
            return ResponseEntity.ok("Session not found or Session out of turn");
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
