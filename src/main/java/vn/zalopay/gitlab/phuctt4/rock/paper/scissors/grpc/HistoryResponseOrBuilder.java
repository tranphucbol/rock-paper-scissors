// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rock-paper-scissors.proto

package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc;

public interface HistoryResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDataResponse data = 1;</code>
   */
  java.util.List<HistoryDataResponse>
      getDataList();
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDataResponse data = 1;</code>
   */
  HistoryDataResponse getData(int index);
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDataResponse data = 1;</code>
   */
  int getDataCount();
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDataResponse data = 1;</code>
   */
  java.util.List<? extends HistoryDataResponseOrBuilder>
      getDataOrBuilderList();
  /**
   * <code>repeated .vn.zalopay.gitlab.phuctt4.rock.paper.scissors.grpc.HistoryDataResponse data = 1;</code>
   */
  HistoryDataResponseOrBuilder getDataOrBuilder(
          int index);
}