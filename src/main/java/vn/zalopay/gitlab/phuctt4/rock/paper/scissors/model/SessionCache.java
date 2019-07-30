package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.model;

import java.io.Serializable;

public class SessionCache implements Serializable {
    private static final long serialVersionUID = 3721868648682458579L;
    private Long userId;
    private String username;
    private Integer win;
    private Integer count;

    public SessionCache() {
    }

    public SessionCache(Long userId, String username, Integer win, Integer count) {
        this.userId = userId;
        this.username = username;
        this.win = win;
        this.count = count;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
