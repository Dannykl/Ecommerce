package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authUserRepository.findByEmail(username);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new HashSet<>());
    }
}
