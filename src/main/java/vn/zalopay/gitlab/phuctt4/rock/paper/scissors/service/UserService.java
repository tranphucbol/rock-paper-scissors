package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.User;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        try {
            userRepository.save(user);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

}
