package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserWinning implements Serializable {
    private static final long serialVersionUID = -5705023414177630450L;
    private String username;
    private Double rate;

    public UserWinning(String username, Double rate) {
        this.username = username;
        this.rate = rate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWinning that = (UserWinning) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
