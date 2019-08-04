package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.DataResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.JwtResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserLoginForm;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.jwt.JwtTokenUtil;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.JwtUserDetailService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailService userDetailService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationController.class);

    @PostMapping(path = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginForm userLoginForm) {
        LOGGER.info("Request /auth");
        try {
            authenticate(userLoginForm.getUsername(), userLoginForm.getPassword());
            final UserDetails userDetails = userDetailService.loadUserByUsername(userLoginForm.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            String message = userLoginForm.getUsername() + " " + e.getMessage();
            LOGGER.error(message);
            DataResponse dataResponse = new DataResponse();
            dataResponse.setError("Wrong username or password");
            return ResponseEntity.ok(dataResponse);
        }

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLE", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
