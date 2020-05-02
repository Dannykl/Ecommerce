package live.zema.ecommerce.bootstrap;

import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        loadUserObjects();
    }

    private void loadUserObjects() {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .email("daniel@gmail.com")
                    .password("pass")
                    .build());
        }
    }
}
