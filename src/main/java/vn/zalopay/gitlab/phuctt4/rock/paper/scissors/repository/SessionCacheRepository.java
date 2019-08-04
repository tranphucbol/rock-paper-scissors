package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserWinning;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionCache;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class SessionCacheRepository {
    private static final String KEY = "sessions";

    @Resource(name="redisTemplate")
    private HashOperations<String, Long, SessionCache> hashOps;

    public void addSessionCache(SessionCache sessionCache) {
        hashOps.put(KEY, sessionCache.getUserId(), sessionCache);
    }

    public void updateSessionCache(User user, Boolean isWinning) {
        SessionCache sessionCache = hashOps.get(KEY, user.getId());
        if(sessionCache == null) {
            sessionCache = new SessionCache(user.getId(), user.getUsername(), isWinning ? 1 : 0, 1);
        } else {
            sessionCache.setCount(sessionCache.getCount() + 1);
            sessionCache.setWin(sessionCache.getWin() + (isWinning ? 1 : 0));
        }
        hashOps.put(KEY, sessionCache.getUserId(), sessionCache);
    }

    public SessionCache getSessionCache(Long userId) {
        return hashOps.get(KEY, userId);
    }

    public Map<Long, SessionCache> getAllSessionCache() {
        return hashOps.entries(KEY);
    }
}
