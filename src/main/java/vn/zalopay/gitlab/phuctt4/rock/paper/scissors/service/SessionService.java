package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Service;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.DataResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserWinning;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionCache;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
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

    @Autowired
    private UserWinningCacheRepository userWinningCacheRepository;

    @PostConstruct
    @Transactional
    private void init() {
        List<User> users = userRepository.findAll();
        List<UserWinning> userWinnings = users.stream()
                .map(user -> new UserWinning(user.getUsername(), getWinningRateOfUser(user)))
                .collect(Collectors.toList());
        userWinnings.forEach(userWinning -> userWinningCacheRepository.addUserWinning(userWinning));
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    public void createSession(String username, Session session) {
        User user = userRepository.findByUsername(username);
        session.setUser(user);
        sessionRepository.save(session);
    }

    public Session getSession(String username, Long sessionId) {
        User user = userRepository.findByUsername(username);

        Session session = sessionRepository.findByIdAndUserId(sessionId, user.getId());
        if (session != null && generalResult(session) != 0) {
            session = null;
        }
        return session;
    }

    public Integer generalResult(Session session) {
        return session.getResult();
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
        if (sessionCache == null) {
//            List<Session> sessions = user.getSessions();
//            for (Session session : sessions) {
//                if (generalResult(session) == 1) {
//                    win++;
//                }
//            }
//            count = sessions.size();
            count = sessionRepository.countByUserId(user.getId());
            win = sessionRepository.countByResultAndUserId(1, user.getId());
            sessionCache = new SessionCache(user.getId(), user.getUsername(), win, count);
            sessionCacheRepository.addSessionCache(sessionCache);
        } else {
            count = sessionCache.getCount();
            win = sessionCache.getWin();
        }
        return count > 0 ? win * 1.0 / count : 0;
    }

    @Transactional
    public List<UserWinning> getTopUser(Integer limit) {
//        List<User> users = userRepository.findAll();
//        List<UserWinning> userWinnings = users.stream()
//                .map(user -> new UserWinning(user.getUsername(), getWinningRateOfUser(user)))
//                .sorted((a, b) -> b.getRate().compareTo(a.getRate()))
//                .limit(limit)
//                .collect(Collectors.toList());
        List<UserWinning> userWinnings = userWinningCacheRepository
                .getByLimit(limit);
        return userWinnings;
    }

    public void updateSessionCache(String username, Boolean isWinning) {
        User user = userRepository.findByUsername(username);
        sessionCacheRepository.updateSessionCache(user, isWinning);
        userWinningCacheRepository.addUserWinning(new UserWinning(username, getWinningRateOfUser(user)));
//        return new UserWinning(username, getWinningRateOfUser(user));
    }

    public Integer checkWin(Integer player, Integer computer) {
        if (player == computer) {
            return 0;
        } else {
            Integer result = 0;
            if (player == 1) {
                if (computer == 2) {
                    result = -1;
                } else {
                    result = 1;
                }
            } else if (player == 2) {
                if (computer == 3) {
                    result = -1;
                } else {
                    result = 1;
                }
            } else {
                if (computer == 1) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
            return result;
        }
    }

    public String getResultToString(Integer result) {
        if (result == -1) {
            return "LOSE";
        } else if (result == 0) {
            return "DRAW";
        } else {
            return "WIN";
        }
    }

    @Transactional
    public DataResponse play(String username, Long id, Integer type) {
        Session session = getSession(username, id);
        DataResponse dataResponse = new DataResponse();

        if (session != null) {
            if (!(type >= 1 && type <= 3)) {
                dataResponse.setError("Wrong type");
                LOGGER.error("Wrong type {}", type);
            } else {
                Random random = new Random();
                Integer computer = random.nextInt(3) + 1;
                Integer result = checkWin(type, computer);

                SessionDetail sessionDetail = new SessionDetail(result, type, session);
                session.addSessionDetail(sessionDetail);

                if (result == 1) {
                    updateSessionCache(username, true);
                    session.setResult(1);

                } else if (result == -1) {
                    updateSessionCache(username, false);
                    session.setResult(-1);
                }
                dataResponse.setResult(getResultToString(result));
                save(session);
            }
        } else {
            dataResponse.setError("Session not found or session out of turn");
            LOGGER.error("Session {} not found or session out of turn", id);
        }
        return dataResponse;
    }
}
