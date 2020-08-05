package live.zema.ecommerce.bootstrap;

import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.UserRepository;
import live.zema.ecommerce.security.PasswordConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author danielniguse
 */

@RequiredArgsConstructor
@Component
public class UserLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordConfig passwordConfig;

    @Override
    public void run(String... args) throws Exception {
        loadUserObjects();
    }

    private void loadUserObjects() {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .email("daniell@gmail.com")
                    .password(
                            passwordConfig.hashPassword("pass"))
                    .build());

            userRepository.save(User.builder()
                    .email("birukdaniel@gmail.com")
                    .password(
                            passwordConfig.hashPassword("pass"))
                    .build());
        }
    }
}
