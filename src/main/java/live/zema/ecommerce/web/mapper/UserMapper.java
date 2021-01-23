package live.zema.ecommerce.web.mapper;

import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.web.model.UserDto;
import org.mapstruct.Mapper;

/**
 * @author danielniguse
 */
@Mapper(uses = DateMapper.class)
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}

