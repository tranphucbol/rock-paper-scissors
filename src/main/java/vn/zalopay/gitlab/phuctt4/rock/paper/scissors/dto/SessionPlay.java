package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model.Session;

public class SessionPlay {
    private Session session;
    private Integer remainTurn;

    public SessionPlay(Session session, Integer remainTurn) {
        this.session = session;
        this.remainTurn = remainTurn;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getRemainTurn() {
        return remainTurn;
    }

    public void setRemainTurn(Integer remainTurn) {
        this.remainTurn = remainTurn;
    }
}
