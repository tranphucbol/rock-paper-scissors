package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.SessionDetail;

public class SessionDetailResponse {
    private Integer result;
    private Integer type;

    public SessionDetailResponse(SessionDetail sessionDetail) {
        this.result = sessionDetail.getResult();
        this.type = sessionDetail.getType();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
