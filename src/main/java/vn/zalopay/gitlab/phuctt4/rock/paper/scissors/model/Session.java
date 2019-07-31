package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Integer turns;

    private Date createdOn = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "session",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SessionDetail> sessionDetails = new ArrayList<>();

    public void addSessionDetail(SessionDetail sessionDetail) {
        sessionDetails.add(sessionDetail);
        sessionDetail.setSession(this);
    }

    public void removeSessionDetail(SessionDetail sessionDetail) {
        sessionDetails.remove(sessionDetail);
        sessionDetail.setSession(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Integer getTurns() {
//        return turns;
//    }
//
//    public void setTurns(Integer turns) {
//        this.turns = turns;
//    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SessionDetail> getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(List<SessionDetail> sessionDetails) {
        this.sessionDetails = sessionDetails;
    }
}
