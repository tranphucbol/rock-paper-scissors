package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionResponse {
    private Long id;
    private Date createdOn;
    private List<SessionDetailResponse> sessionDetailResponses = new ArrayList<>();

    public SessionResponse(Session session) {
        this.id = session.getId();
        this.createdOn = session.getCreatedOn();
        session.getSessionDetails().forEach(sessionDetail -> {
            this.sessionDetailResponses.add(new SessionDetailResponse(sessionDetail));
        });
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<SessionDetailResponse> getSessionDetailResponses() {
        return sessionDetailResponses;
    }

    public void setSessionDetailResponses(List<SessionDetailResponse> sessionDetailResponses) {
        this.sessionDetailResponses = sessionDetailResponses;
    }
}
