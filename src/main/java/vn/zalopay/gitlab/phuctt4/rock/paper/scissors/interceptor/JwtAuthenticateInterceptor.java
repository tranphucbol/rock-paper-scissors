package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.interceptor;

import io.grpc.*;
import io.jsonwebtoken.ExpiredJwtException;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.Constants;
import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.jwt.JwtTokenUtil;

import static vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.Constants.JWT_METADATA_KEY;

@GRpcGlobalInterceptor
public class JwtAuthenticateInterceptor implements ServerInterceptor {

    private static final ServerCall.Listener NOOP_LISTENER = new ServerCall.Listener() {
    };

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        String token = metadata.get(JWT_METADATA_KEY);
        if(token == null) {
            serverCall.close(Status.UNAUTHENTICATED
                    .withDescription("JWT Token is missing from Metadata"), metadata);
            return NOOP_LISTENER;
        }
        String username = null;
        try {
            username = jwtTokenUtil.getUsernameFromToken(token);
            Context ctx = Context.current().withValue(Constants.USER_NAME_CTX_KEY, username);
            return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
//            return serverCallHandler.startCall(serverCall, metadata);
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to get JWT Token");
            serverCall.close(Status.UNAUTHENTICATED
                    .withDescription(e.getMessage()).withCause(e), metadata);
        } catch (ExpiredJwtException e) {
            System.out.println("JWT Token has expired");
            serverCall.close(Status.UNAUTHENTICATED
                    .withDescription(e.getMessage()).withCause(e), metadata);
        }
        return NOOP_LISTENER;
    }
}
