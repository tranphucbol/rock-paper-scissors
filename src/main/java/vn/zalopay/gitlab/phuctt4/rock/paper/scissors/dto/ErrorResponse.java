package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

public class ErrorResponse {
    private Object error;

    public ErrorResponse(Object error) {
        this.error = error;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
