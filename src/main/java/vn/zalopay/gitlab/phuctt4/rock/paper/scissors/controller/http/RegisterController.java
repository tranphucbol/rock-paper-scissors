package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.http;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.DataResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserLoginForm;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.UserService;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@RequestBody UserLoginForm userLoginForm) {
        LOGGER.info("Request /register");
        DataResponse dataResponse = new DataResponse();
        if(userService.registerUser(userLoginForm.getUsername(), userLoginForm.getPassword())) {
            LOGGER.info("{} registers successfully", userLoginForm.getUsername());
            dataResponse.setMessage("Registering successfully");
        } else {
            dataResponse.setError("Username existed");
            LOGGER.error("Username {} existed", userLoginForm.getUsername());
        }
        return ResponseEntity.ok(dataResponse);
    }

}
