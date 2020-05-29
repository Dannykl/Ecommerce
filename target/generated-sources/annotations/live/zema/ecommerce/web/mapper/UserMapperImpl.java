package live.zema.ecommerce.web.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.domain.RoleType;
import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.domain.User.UserBuilder;
import live.zema.ecommerce.web.model.UserDto;
import live.zema.ecommerce.web.model.UserDto.UserDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T22:58:05+0100",
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
        Set<Order> set = user.getOrders();
        if ( set != null ) {
            userDto.orders( new HashSet<Order>( set ) );
        }
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
        Set<Order> set = userDto.getOrders();
        if ( set != null ) {
            user.orders( new HashSet<Order>( set ) );
        }
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
}
