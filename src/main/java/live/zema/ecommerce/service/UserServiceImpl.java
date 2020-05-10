package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.UserRepository;
import live.zema.ecommerce.web.mapper.UserMapper;
import live.zema.ecommerce.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isEmpty() ? Optional.empty() : Optional.of(userMapper.userToUserDto(user.get()));
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }
}
