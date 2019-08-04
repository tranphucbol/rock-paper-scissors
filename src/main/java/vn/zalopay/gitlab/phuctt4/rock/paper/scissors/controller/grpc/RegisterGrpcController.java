package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.RegisterServiceGrpc;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.UserRequest;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.UserResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.jwt.JwtTokenUtil;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.repository.UserRepository;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.UserService;

@GRpcService(applyGlobalInterceptors = false)
public class RegisterGrpcController extends RegisterServiceGrpc.RegisterServiceImplBase {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void register(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        userService.registerUser(request.getUsername(), request.getUsername());
        UserResponse response = UserResponse.newBuilder()
                .setToken(jwtTokenUtil.generateToken(request.getUsername()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
