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
public final class SessionServiceGrpc {

  private SessionServiceGrpc() {}

  public static final String SERVICE_NAME = "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<SessionRequest,
      SessionResponse> getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createSession",
      requestType = SessionRequest.class,
      responseType = SessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionRequest,
      SessionResponse> getCreateSessionMethod() {
    io.grpc.MethodDescriptor<SessionRequest, SessionResponse> getCreateSessionMethod;
    if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
          SessionServiceGrpc.getCreateSessionMethod = getCreateSessionMethod =
              io.grpc.MethodDescriptor.<SessionRequest, SessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService", "createSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("createSession"))
                  .build();
          }
        }
     }
     return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionRequest,
      SessionResponse> getGetAllHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllHistory",
      requestType = SessionRequest.class,
      responseType = SessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionRequest,
      SessionResponse> getGetAllHistoryMethod() {
    io.grpc.MethodDescriptor<SessionRequest, SessionResponse> getGetAllHistoryMethod;
    if ((getGetAllHistoryMethod = SessionServiceGrpc.getGetAllHistoryMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getGetAllHistoryMethod = SessionServiceGrpc.getGetAllHistoryMethod) == null) {
          SessionServiceGrpc.getGetAllHistoryMethod = getGetAllHistoryMethod =
              io.grpc.MethodDescriptor.<SessionRequest, SessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService", "getAllHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("getAllHistory"))
                  .build();
          }
        }
     }
     return getGetAllHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TopRequest,
      TopResponse> getGetTopLimitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTopLimit",
      requestType = TopRequest.class,
      responseType = TopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TopRequest,
      TopResponse> getGetTopLimitMethod() {
    io.grpc.MethodDescriptor<TopRequest, TopResponse> getGetTopLimitMethod;
    if ((getGetTopLimitMethod = SessionServiceGrpc.getGetTopLimitMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getGetTopLimitMethod = SessionServiceGrpc.getGetTopLimitMethod) == null) {
          SessionServiceGrpc.getGetTopLimitMethod = getGetTopLimitMethod =
              io.grpc.MethodDescriptor.<TopRequest, TopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService", "getTopLimit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TopResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("getTopLimit"))
                  .build();
          }
        }
     }
     return getGetTopLimitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<PlayRequest,
      PlayResponse> getPlayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "play",
      requestType = PlayRequest.class,
      responseType = PlayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PlayRequest,
      PlayResponse> getPlayMethod() {
    io.grpc.MethodDescriptor<PlayRequest, PlayResponse> getPlayMethod;
    if ((getPlayMethod = SessionServiceGrpc.getPlayMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getPlayMethod = SessionServiceGrpc.getPlayMethod) == null) {
          SessionServiceGrpc.getPlayMethod = getPlayMethod =
              io.grpc.MethodDescriptor.<PlayRequest, PlayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.SessionService", "play"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PlayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PlayResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("play"))
                  .build();
          }
        }
     }
     return getPlayMethod;
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
    public void createSession(SessionRequest request,
                              io.grpc.stub.StreamObserver<SessionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSessionMethod(), responseObserver);
    }

    /**
     */
    public void getAllHistory(SessionRequest request,
                              io.grpc.stub.StreamObserver<SessionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllHistoryMethod(), responseObserver);
    }

    /**
     */
    public void getTopLimit(TopRequest request,
                            io.grpc.stub.StreamObserver<TopResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTopLimitMethod(), responseObserver);
    }

    /**
     */
    public void play(PlayRequest request,
                     io.grpc.stub.StreamObserver<PlayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPlayMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSessionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SessionRequest,
                SessionResponse>(
                  this, METHODID_CREATE_SESSION)))
          .addMethod(
            getGetAllHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SessionRequest,
                SessionResponse>(
                  this, METHODID_GET_ALL_HISTORY)))
          .addMethod(
            getGetTopLimitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TopRequest,
                TopResponse>(
                  this, METHODID_GET_TOP_LIMIT)))
          .addMethod(
            getPlayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                PlayRequest,
                PlayResponse>(
                  this, METHODID_PLAY)))
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
    public void createSession(SessionRequest request,
                              io.grpc.stub.StreamObserver<SessionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllHistory(SessionRequest request,
                              io.grpc.stub.StreamObserver<SessionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTopLimit(TopRequest request,
                            io.grpc.stub.StreamObserver<TopResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTopLimitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void play(PlayRequest request,
                     io.grpc.stub.StreamObserver<PlayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPlayMethod(), getCallOptions()), request, responseObserver);
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
    public SessionResponse createSession(SessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     */
    public SessionResponse getAllHistory(SessionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public TopResponse getTopLimit(TopRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTopLimitMethod(), getCallOptions(), request);
    }

    /**
     */
    public PlayResponse play(PlayRequest request) {
      return blockingUnaryCall(
          getChannel(), getPlayMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<SessionResponse> createSession(
        SessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SessionResponse> getAllHistory(
        SessionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TopResponse> getTopLimit(
        TopRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTopLimitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PlayResponse> play(
        PlayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPlayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_GET_ALL_HISTORY = 1;
  private static final int METHODID_GET_TOP_LIMIT = 2;
  private static final int METHODID_PLAY = 3;

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
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession((SessionRequest) request,
              (io.grpc.stub.StreamObserver<SessionResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_HISTORY:
          serviceImpl.getAllHistory((SessionRequest) request,
              (io.grpc.stub.StreamObserver<SessionResponse>) responseObserver);
          break;
        case METHODID_GET_TOP_LIMIT:
          serviceImpl.getTopLimit((TopRequest) request,
              (io.grpc.stub.StreamObserver<TopResponse>) responseObserver);
          break;
        case METHODID_PLAY:
          serviceImpl.play((PlayRequest) request,
              (io.grpc.stub.StreamObserver<PlayResponse>) responseObserver);
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
      return RockPaperScissors.getDescriptor();
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
              .addMethod(getCreateSessionMethod())
              .addMethod(getGetAllHistoryMethod())
              .addMethod(getGetTopLimitMethod())
              .addMethod(getPlayMethod())
              .build();
        }
      }
    }
    return result;
  }
}
