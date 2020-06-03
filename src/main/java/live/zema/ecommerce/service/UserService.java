package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.UserDto;

import java.util.Optional;

/**
 * @author danielniguse
 */
public interface UserService {
    //TODO TO BE REMOVED
    Optional<UserDto> findByEmail(String email);

    UserDto save(UserDto userDto);

}
