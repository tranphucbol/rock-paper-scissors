package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.MetadataUtils;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.AuthServiceGrpc;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.RegisterServiceGrpc;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.UserRequest;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.UserResponse;

public class AuthGrpcClient {
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;
    private RegisterServiceGrpc.RegisterServiceBlockingStub registerServiceBlockingStub;
    private ManagedChannel managedChannel;

    public AuthGrpcClient() {
        managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 6565)
                .usePlaintext()
                .build();
        authServiceBlockingStub = AuthServiceGrpc.newBlockingStub(managedChannel);
        registerServiceBlockingStub = RegisterServiceGrpc.newBlockingStub(managedChannel);
    }

    public String auth(String username, String password) {
        UserRequest request = UserRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();
        UserResponse response = authServiceBlockingStub.auth(request);
        return response.getToken();
    }

    public String register(String username, String password) {
        UserRequest request = UserRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();
        UserResponse response = registerServiceBlockingStub.register(request);
        return response.getToken();
    }
}
