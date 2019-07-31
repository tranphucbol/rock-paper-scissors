package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByIdAndUserId(Long id, Long userId);
    List<Session> findAllByUser(User user);
}
