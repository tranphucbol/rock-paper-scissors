package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserWinning;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserWinningCacheRepository {
    private static final String KEY = "user_winnings";

    @Resource(name="redisTemplate")
    private ZSetOperations<String, String> zSetOperations;

    public void addUserWinning(UserWinning userWinning) {
        zSetOperations.add(KEY, userWinning.getUsername(), userWinning.getRate());
    }

    public List<UserWinning> getByLimit(Integer limit) {
        return zSetOperations.reverseRangeWithScores(KEY, 0, limit - 1)
                .stream()
                .map(tuple -> new UserWinning(tuple.getValue(), tuple.getScore()))
                .collect(Collectors.toList());
    }

}
