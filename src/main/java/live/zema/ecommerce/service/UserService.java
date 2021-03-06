package live.zema.ecommerce.service;

import live.zema.ecommerce.model.SignupResponse;
import live.zema.ecommerce.model.UserDto;

import java.util.Optional;

/**
 * @author danielniguse
 */
public interface UserService {

    Optional<UserDto> findByEmail(String email);

    SignupResponse save(UserDto userDto);

}
