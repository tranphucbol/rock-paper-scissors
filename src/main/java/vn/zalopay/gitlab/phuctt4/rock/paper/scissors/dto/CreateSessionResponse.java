package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

public class CreateSessionResponse {
    private Long id;

    public CreateSessionResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
