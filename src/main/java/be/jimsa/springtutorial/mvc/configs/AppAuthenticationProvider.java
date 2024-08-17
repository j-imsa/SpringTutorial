package be.jimsa.springtutorial.mvc.configs;

import be.jimsa.springtutorial.mvc.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppAuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        return userRepository.findByEmail(username)
                .map(userEntity -> {
                    if (passwordEncoder.matches(password, userEntity.getPassword())) {
                        return new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                authentication.getAuthorities().stream().toList()
                        );
                    } else {
                        return null;
                    }
                })
                .orElse(null);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
