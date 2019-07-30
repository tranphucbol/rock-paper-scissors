package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

public class UserWinning {
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
}
