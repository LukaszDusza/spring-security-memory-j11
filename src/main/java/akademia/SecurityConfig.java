package akademia;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.undo.AbstractUndoableEdit;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private PasswordEncoder passwordEncoder;

  public SecurityConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
        .passwordEncoder(passwordEncoder)
        .withUser("user")
        .password("$2a$10$DDbDD0o1C.6l.MJosgePPOd.FdsuJR76es3k/zDz3.B2V1x9HfZRG")
        .roles("USER")
        .and()
        .withUser("admin")
        .password("$2a$10$7rNkaEYvfvWHarrCh7BHeeuyiRSGp5brGz8owbXsBDtrQgEm78yEO")
        .roles("ADMIN", "USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/user").hasAnyRole("USER", "ADMIN")
        .antMatchers("/admin").hasAnyRole("ADMIN")
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .defaultSuccessUrl("/home")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/home");
  }
}
