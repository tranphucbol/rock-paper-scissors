package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.AuthServiceGrpc;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.UserRequest;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.UserResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.interceptor.JwtAuthenticateInterceptor;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.jwt.JwtTokenUtil;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.JwtUserDetailService;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.UserService;

@GRpcService(applyGlobalInterceptors = false)
public class JwtAuthenticationGrpcController extends AuthServiceGrpc.AuthServiceImplBase {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void auth(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        try {
            authenticate(request.getUsername(), request.getPassword());
            final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(request.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            UserResponse response = UserResponse.newBuilder().setToken(token).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
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
