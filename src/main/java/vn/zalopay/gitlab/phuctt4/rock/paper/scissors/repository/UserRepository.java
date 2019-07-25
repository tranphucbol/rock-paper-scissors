package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
