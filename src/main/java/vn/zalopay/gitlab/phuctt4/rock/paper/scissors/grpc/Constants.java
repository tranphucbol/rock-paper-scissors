package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc;

import io.grpc.Context;
import io.grpc.Metadata;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class Constants {
    public static final Context.Key<String> USER_NAME_CTX_KEY = Context.key("username");
    public static final Metadata.Key<String> JWT_METADATA_KEY =
            Metadata.Key.of("jwt", ASCII_STRING_MARSHALLER);
}
