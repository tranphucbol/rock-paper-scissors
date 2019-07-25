package vn.zalopay.gitlab.phuctt4.rock.paper.scissors.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -1136433058802378215L;

    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
