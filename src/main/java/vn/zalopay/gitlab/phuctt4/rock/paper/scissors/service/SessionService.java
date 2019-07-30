package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.SessionPlay;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserWinning;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionCache;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.SessionCacheRepository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.SessionDetailRepository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.SessionRepository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionDetailRepository sessionDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionCacheRepository sessionCacheRepository;

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
//        int countWin = 0;
//        int countLose = 0;

//        for(SessionDetail sd : session.getSessionDetails()) {
//            if(sd.getResult() == -1)
//                countLose++;
//            else if(sd.getResult() == 1)
//                countWin++;
//        }

        int countWin = sessionDetailRepository.countBySessionIdAndResult(session.getId(), 1);
        int countLose = sessionDetailRepository.countBySessionIdAndResult(session.getId(), -1);

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

    public List<Session> getAllSessionByUser(String username) {
        User user = userRepository.findByUsername(username);

        List<Session> sessions = sessionRepository.findAllByUser(user);
        return sessions;
    }

    public Double getWinningRateOfUser(User user) {
        SessionCache sessionCache = sessionCacheRepository.getSessionCache(user.getId());
        Integer win = 0, count = 0;
        if(sessionCache == null) {
            List<Session> sessions = user.getSessions();

            for(Session session : sessions) {
                if(generalResult(session) == 1) {
                    win++;
                }
            }
            count = sessions.size();
            sessionCache = new SessionCache(user.getId(), user.getUsername(), win, count);
            sessionCacheRepository.addSessionCache(sessionCache);
        } else {
            count = sessionCache.getCount();
            win = sessionCache.getWin();
        }
        return count > 0 ? win * 1.0 / count : 0;
    }

    public List<UserWinning> getTopUser(Integer limit) {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserWinning(user.getUsername(), getWinningRateOfUser(user)))
                .sorted((a, b) -> b.getRate().compareTo(a.getRate()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public void updateSessionCache(String username, Boolean isWinning) {
        User user = userRepository.findByUsername(username);
        sessionCacheRepository.updateSessionCache(user, isWinning);
    }
}
