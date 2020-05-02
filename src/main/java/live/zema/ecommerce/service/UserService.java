package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.UserDto;

import java.util.Optional;

/**
 * @author danielniguse
 */
public interface UserService {
    Optional<UserDto> findByEmail(String email);
}
