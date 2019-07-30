package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -1136433058802378215L;

    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
