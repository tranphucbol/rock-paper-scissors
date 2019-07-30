package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

public class DataResponse {
    private Object data;

    public DataResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
