package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.UserRepository;
import live.zema.ecommerce.web.mapper.DateMapper;
import live.zema.ecommerce.web.mapper.UserMapper;
import live.zema.ecommerce.web.model.OrderDto;
import live.zema.ecommerce.web.model.SignupResponse;
import live.zema.ecommerce.web.model.UserDto;
import live.zema.ecommerce.web.security.PasswordConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final DateMapper dateMapper;
    private final OrderServiceImpl orderServiceImp;
    private final PasswordConfig passwordConfig;

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        Set<OrderDto> orders = new HashSet<>();
        UserDto userDto;


        if (user.isEmpty()) {
            return Optional.empty();
        }

        for(Order order : user.get().getOrders()){
            orders.add(new OrderDto(order.getId(),dateMapper.asOffsetDateTime(
                    order.getCreatedDate()), orderServiceImp.lineItemToLineItemDto(order.getLineItems()),null));
        }

        userDto = new UserDto(user.get().getEmail(),user.get().getPassword(),
                null,
                orders,dateMapper.asOffsetDateTime(user.get().getCreatedDate()));

        return Optional.of(userDto);
    }

    @Override
    public SignupResponse save(UserDto userDto) {
        userDto.setPassword(passwordConfig.hashPassword(userDto.getPassword()));
        var user = userRepository.save(userMapper.userDtoToUser(userDto));
        return new SignupResponse(user.getEmail(),"account is created",dateMapper.asOffsetDateTime(user.getCreatedDate()));

    }

}
