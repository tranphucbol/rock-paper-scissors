package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.*;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.interceptor.JwtAuthenticateInterceptor;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

@GRpcService(interceptors = JwtAuthenticateInterceptor.class)
public class SessionGrpcController extends SessionServiceGrpc.SessionServiceImplBase {
    @Autowired
    private SessionService sessionService;

    @Override
    public void createSession(SessionRequest request, StreamObserver<SessionResponse> responseObserver) {
        Session session = new Session();
        String username = Constants.USER_NAME_CTX_KEY.get();
        sessionService.createSession(username, session);
        SessionResponse response = SessionResponse.newBuilder().setId(session.getId()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void play(PlayRequest request, StreamObserver<PlayResponse> responseObserver) {

    }
}
