package be.jimsa.springtutorial.mvc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(httpSecurityCsrfConfigurer ->
                        httpSecurityCsrfConfigurer
                                .ignoringRequestMatchers("/api/**", "/saveMessage")
                )
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/api/**").permitAll();
                    authorizeRequests.requestMatchers("/actuator/**").permitAll();
                    authorizeRequests.requestMatchers("/assets/**").permitAll();
                    authorizeRequests.requestMatchers("/", "/home").permitAll();
                    authorizeRequests.requestMatchers("/about").permitAll();
                    authorizeRequests.requestMatchers("/course/**").permitAll();
                    authorizeRequests.requestMatchers("/contact").permitAll();
                    authorizeRequests.requestMatchers("/saveMessage").permitAll();
                    authorizeRequests.requestMatchers("/login").permitAll();
                    authorizeRequests.requestMatchers("/login?error=true").permitAll();
                    authorizeRequests.requestMatchers("/login?logout=true").permitAll();
                    authorizeRequests.requestMatchers("/logout").permitAll();
                    authorizeRequests.requestMatchers("/dashboard").authenticated();
                })
                .formLogin(formLoginConfigurer -> {
                    formLoginConfigurer.loginPage("/login");
                    formLoginConfigurer.successForwardUrl("/dashboard");
                    formLoginConfigurer.failureUrl("/login?error=true");
                })
                .logout(logoutConfigurer -> {
                    logoutConfigurer.logoutSuccessUrl("/login?logout=true");
                    logoutConfigurer.invalidateHttpSession(true);
                })
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordValidator() {
        return new BCryptPasswordEncoder();
    }

}
