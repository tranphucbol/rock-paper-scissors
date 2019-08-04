package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DataResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object message;

    public DataResponse() {
    }

    public DataResponse(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
