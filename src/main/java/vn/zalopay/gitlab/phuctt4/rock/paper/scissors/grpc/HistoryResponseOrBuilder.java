// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rock-paper-scissors.proto

package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc;

public interface HistoryResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>string createdOn = 2;</code>
   */
  String getCreatedOn();
  /**
   * <code>string createdOn = 2;</code>
   */
  com.google.protobuf.ByteString
      getCreatedOnBytes();

  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDetailResponse historyDetailResponse = 3;</code>
   */
  java.util.List<HistoryDetailResponse>
      getHistoryDetailResponseList();
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDetailResponse historyDetailResponse = 3;</code>
   */
  HistoryDetailResponse getHistoryDetailResponse(int index);
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDetailResponse historyDetailResponse = 3;</code>
   */
  int getHistoryDetailResponseCount();
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDetailResponse historyDetailResponse = 3;</code>
   */
  java.util.List<? extends HistoryDetailResponseOrBuilder>
      getHistoryDetailResponseOrBuilderList();
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDetailResponse historyDetailResponse = 3;</code>
   */
  HistoryDetailResponseOrBuilder getHistoryDetailResponseOrBuilder(
          int index);
}
