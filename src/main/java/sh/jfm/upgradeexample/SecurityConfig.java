package sh.jfm.upgradeexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Previously SecurityConfigs extended WebSecurityConfigurerAdapter now a SecurityFilterChain bean is used for
 * configuration.
 * <p>
 * See <a href="https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter">Spring
 * Security without WebSecurityConfigurerAdapter</a> for more details.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * The previous antMatchers implementation was removed in favor of requestMatchers.
     * <p>
     * See <a href="https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html#use-new-requestmatchers">
     * Configuration Migrations - Use the new requestMatchers methods
     * </a> for more details.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/message", "/db-messages").permitAll()
                        .requestMatchers("/secure-message").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
