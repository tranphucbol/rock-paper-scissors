package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.interceptor.JwtAuthenticateInterceptor;

import javax.annotation.PostConstruct;

import static vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.Constants.JWT_METADATA_KEY;

public class SessionGrpcClient {
    private SessionServiceGrpc.SessionServiceBlockingStub sessionServiceBlockingStub;
    private String token;
    private ManagedChannel managedChannel;

    public SessionGrpcClient(String token) {
        this.token = token;
        this.init();
    }

    private void init() {
        Metadata metadata = new Metadata();
        metadata.put(JWT_METADATA_KEY, token);
        managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 6565)
                .usePlaintext()
                .intercept(MetadataUtils.newAttachHeadersInterceptor(metadata))
                .build();
        sessionServiceBlockingStub = SessionServiceGrpc.newBlockingStub(managedChannel);
    }

    public Long createSession() {
        SessionRequest request = SessionRequest.newBuilder().build();
        SessionResponse response = sessionServiceBlockingStub
                .createSession(request);
        return response.getId();
    }
}
