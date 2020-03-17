package akademia;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

  @Test
  void contextLoads() {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    System.out.println("user -> " + passwordEncoder.encode("user"));
    System.out.println("admin -> " + passwordEncoder.encode("admin"));
  }
}

