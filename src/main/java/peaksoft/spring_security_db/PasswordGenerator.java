package peaksoft.spring_security_db;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String  password = "Bekmurat";
        String encode = encoder.encode(password);
        System.out.println(encode);
    }
}
