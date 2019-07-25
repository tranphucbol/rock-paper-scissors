package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;

@Repository
public interface SessionDetailRepository extends JpaRepository<SessionDetail, Long> {
    int countBySessionId(Long sessionId);
}
