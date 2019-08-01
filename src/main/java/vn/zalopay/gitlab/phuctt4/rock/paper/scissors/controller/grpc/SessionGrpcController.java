package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionServiceGrpc;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

@GRpcService
public class SessionGrpcController extends SessionServiceGrpc.SessionServiceImplBase {
    @Autowired
    private SessionService sessionService;

    @Override
    public void createSession(SessionRequest request, StreamObserver<SessionResponse> responseObserver) {
        Session session = new Session();
        sessionService.createSession("tranphucbol", session);
        SessionResponse response = SessionResponse.newBuilder().setId(session.getId()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
