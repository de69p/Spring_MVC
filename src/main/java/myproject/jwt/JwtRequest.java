package myproject.jwt;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class JwtRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;

    // need default constructor for JSON Parsing
    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
