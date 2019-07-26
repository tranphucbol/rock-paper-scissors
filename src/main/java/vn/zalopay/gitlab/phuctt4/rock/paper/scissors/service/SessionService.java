package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.SessionPlay;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.SessionDetailRepository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.SessionRepository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.UserRepository;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionDetailRepository sessionDetailRepository;

    @Autowired
    private UserRepository userRepository;

    public void createSession(String username, Session session) {
        User user = userRepository.findByUsername(username);
        session.setUser(user);
        sessionRepository.save(session);
    }

    public SessionPlay getSessionPlay(String username, Long sessionId) {
        User user = userRepository.findByUsername(username);

        Session session = sessionRepository.findByIdAndUser(sessionId, user);
        int count = sessionDetailRepository.countBySessionId(sessionId);
        return new SessionPlay(session, session.getTurns() - count);
    }

    public Integer generalResult(Session session) {
        int countWin = 0;
        int countLose = 0;

        for(SessionDetail sd : session.getSessionDetails()) {
            if(sd.getResult() == -1)
                countLose++;
            else if(sd.getResult() == 1)
                countWin++;
        }

        if(countLose >  countWin) {
            return -1;
        } else if(countLose < countWin) {
            return 1;
        } else {
            return 0;
        }
    }

    public void save(Session session) {
        sessionRepository.save(session);
    }
}
