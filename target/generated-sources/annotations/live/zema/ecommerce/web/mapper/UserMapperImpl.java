package live.zema.ecommerce.web.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.domain.Order.OrderBuilder;
import live.zema.ecommerce.domain.RoleType;
import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.domain.User.UserBuilder;
import live.zema.ecommerce.web.model.OrderDto;
import live.zema.ecommerce.web.model.OrderDto.OrderDtoBuilder;
import live.zema.ecommerce.web.model.UserDto;
import live.zema.ecommerce.web.model.UserDto.UserDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-04T20:43:07+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.email( user.getEmail() );
        userDto.password( user.getPassword() );
        userDto.roleType( roleTypeToRoleType( user.getRoleType() ) );
        userDto.orders( orderSetToOrderDtoSet( user.getOrders() ) );
        userDto.createdDate( dateMapper.asOffsetDateTime( user.getCreatedDate() ) );

        return userDto.build();
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.email( userDto.getEmail() );
        user.password( userDto.getPassword() );
        user.roleType( roleTypeToRoleType1( userDto.getRoleType() ) );
        user.orders( orderDtoSetToOrderSet( userDto.getOrders() ) );
        user.createdDate( dateMapper.asTimestamp( userDto.getCreatedDate() ) );

        return user.build();
    }

    protected live.zema.ecommerce.web.model.RoleType roleTypeToRoleType(RoleType roleType) {
        if ( roleType == null ) {
            return null;
        }

        live.zema.ecommerce.web.model.RoleType roleType1;

        switch ( roleType ) {
            case Customer: roleType1 = live.zema.ecommerce.web.model.RoleType.Customer;
            break;
            case Admin: roleType1 = live.zema.ecommerce.web.model.RoleType.Admin;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + roleType );
        }

        return roleType1;
    }

    protected OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDtoBuilder orderDto = OrderDto.builder();

        if ( order.getId() != null ) {
            orderDto.id( order.getId() );
        }
        orderDto.createdDate( dateMapper.asOffsetDateTime( order.getCreatedDate() ) );

        return orderDto.build();
    }

    protected Set<OrderDto> orderSetToOrderDtoSet(Set<Order> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDto> set1 = new HashSet<OrderDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Order order : set ) {
            set1.add( orderToOrderDto( order ) );
        }

        return set1;
    }

    protected RoleType roleTypeToRoleType1(live.zema.ecommerce.web.model.RoleType roleType) {
        if ( roleType == null ) {
            return null;
        }

        RoleType roleType1;

        switch ( roleType ) {
            case Customer: roleType1 = RoleType.Customer;
            break;
            case Admin: roleType1 = RoleType.Admin;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + roleType );
        }

        return roleType1;
    }

    protected Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.id( orderDto.getId() );
        order.createdDate( dateMapper.asTimestamp( orderDto.getCreatedDate() ) );

        return order.build();
    }

    protected Set<Order> orderDtoSetToOrderSet(Set<OrderDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Order> set1 = new HashSet<Order>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDto orderDto : set ) {
            set1.add( orderDtoToOrder( orderDto ) );
        }

        return set1;
    }
}
