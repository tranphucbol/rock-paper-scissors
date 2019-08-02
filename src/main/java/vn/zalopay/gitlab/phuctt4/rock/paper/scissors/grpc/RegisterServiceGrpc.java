package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: rock-paper-scissors.proto")
public final class RegisterServiceGrpc {

  private RegisterServiceGrpc() {}

  public static final String SERVICE_NAME = "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.RegisterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UserRequest,
      UserResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = UserRequest.class,
      responseType = UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UserRequest,
      UserResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<UserRequest, UserResponse> getRegisterMethod;
    if ((getRegisterMethod = RegisterServiceGrpc.getRegisterMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getRegisterMethod = RegisterServiceGrpc.getRegisterMethod) == null) {
          RegisterServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<UserRequest, UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.RegisterService", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterServiceStub newStub(io.grpc.Channel channel) {
    return new RegisterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegisterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegisterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RegisterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(UserRequest request,
                         io.grpc.stub.StreamObserver<UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UserRequest,
                UserResponse>(
                  this, METHODID_REGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class RegisterServiceStub extends io.grpc.stub.AbstractStub<RegisterServiceStub> {
    private RegisterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RegisterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(UserRequest request,
                         io.grpc.stub.StreamObserver<UserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegisterServiceBlockingStub extends io.grpc.stub.AbstractStub<RegisterServiceBlockingStub> {
    private RegisterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RegisterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public UserResponse register(UserRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegisterServiceFutureStub extends io.grpc.stub.AbstractStub<RegisterServiceFutureStub> {
    private RegisterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RegisterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserResponse> register(
        UserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegisterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((UserRequest) request,
              (io.grpc.stub.StreamObserver<UserResponse>) responseObserver);
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

  private static abstract class RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return RockPaperScissors.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterService");
    }
  }

  private static final class RegisterServiceFileDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier {
    RegisterServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterServiceMethodDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegisterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
