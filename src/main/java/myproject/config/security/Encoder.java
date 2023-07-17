package myproject.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");

        System.out.println(encode);
    }
}
