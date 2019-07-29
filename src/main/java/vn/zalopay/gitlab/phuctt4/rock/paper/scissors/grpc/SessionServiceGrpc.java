package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: rock-paper-scissors.proto")
public final class SessionServiceGrpc {

  private SessionServiceGrpc() {}

  public static final String SERVICE_NAME = "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest,
      vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse> getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createService",
      requestType = vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest.class,
      responseType = vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest,
      vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse> getCreateServiceMethod() {
    io.grpc.MethodDescriptor<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest, vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse> getCreateServiceMethod;
    if ((getCreateServiceMethod = SessionServiceGrpc.getCreateServiceMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getCreateServiceMethod = SessionServiceGrpc.getCreateServiceMethod) == null) {
          SessionServiceGrpc.getCreateServiceMethod = getCreateServiceMethod = 
              io.grpc.MethodDescriptor.<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest, vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService", "createService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("createService"))
                  .build();
          }
        }
     }
     return getCreateServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SessionServiceStub newStub(io.grpc.Channel channel) {
    return new SessionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SessionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SessionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SessionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SessionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createService(vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest request,
        io.grpc.stub.StreamObserver<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateServiceMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest,
                vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse>(
                  this, METHODID_CREATE_SERVICE)))
          .build();
    }
  }

  /**
   */
  public static final class SessionServiceStub extends io.grpc.stub.AbstractStub<SessionServiceStub> {
    private SessionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SessionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SessionServiceStub(channel, callOptions);
    }

    /**
     */
    public void createService(vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest request,
        io.grpc.stub.StreamObserver<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SessionServiceBlockingStub extends io.grpc.stub.AbstractStub<SessionServiceBlockingStub> {
    private SessionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SessionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SessionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse createService(vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SessionServiceFutureStub extends io.grpc.stub.AbstractStub<SessionServiceFutureStub> {
    private SessionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SessionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SessionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse> createService(
        vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SERVICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SessionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SessionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService((vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionRequest) request,
              (io.grpc.stub.StreamObserver<vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.RockPaperScissors.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionService");
    }
  }

  private static final class SessionServiceFileDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier {
    SessionServiceFileDescriptorSupplier() {}
  }

  private static final class SessionServiceMethodDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SessionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SessionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SessionServiceFileDescriptorSupplier())
              .addMethod(getCreateServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
