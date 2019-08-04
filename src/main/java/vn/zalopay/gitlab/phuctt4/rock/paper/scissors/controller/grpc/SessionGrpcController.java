package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.controller.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.DataResponse;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto.UserWinning;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.*;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.interceptor.JwtAuthenticateInterceptor;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.service.SessionService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
        String username = Constants.USER_NAME_CTX_KEY.get();
        DataResponse dataResponse = sessionService.play(username, request.getId(), request.getType());
        PlayResponse response = PlayResponse.newBuilder().setResult((String)dataResponse.getResult()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void getAllHistory(HistoryRequest request, StreamObserver<HistoryResponse> responseObserver) {
        String username = Constants.USER_NAME_CTX_KEY.get();
        List<Session> sessions = sessionService.getAllSessionByUser(username);
        List<HistoryDataResponse> historyDataResponses = new ArrayList<>();
        sessions.forEach(session -> {
            List<HistoryDetailResponse> details = new ArrayList<>();

            session.getSessionDetails().forEach(sessionDetail -> {
                HistoryDetailResponse detailResponse = HistoryDetailResponse.newBuilder()
                        .setResult(sessionDetail.getResult())
                        .setType(sessionDetail.getType())
                        .build();
                details.add(detailResponse);
            });

            HistoryDataResponse data = HistoryDataResponse
                    .newBuilder()
                    .setId(session.getId())
                    .setCreatedOn(session.getCreatedOn().toString())
                    .addAllHistoryDetailResponse(details)
                    .build();

            historyDataResponses.add(data);
        });

        HistoryResponse response = HistoryResponse.newBuilder().addAllData(historyDataResponses).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getTopLimit(TopRequest request, StreamObserver<TopResponse> responseObserver) {
        List<UserWinning> userWinnings = sessionService.getTopUser(request.getLimit());
        List<TopDataResponse> data = new ArrayList<>();
        userWinnings.forEach(userWinning -> {
            TopDataResponse d = TopDataResponse.newBuilder()
                    .setUsername(userWinning.getUsername())
                    .setRate(userWinning.getRate())
                    .build();
            data.add(d);
        });
        TopResponse response = TopResponse.newBuilder().addAllData(data).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
