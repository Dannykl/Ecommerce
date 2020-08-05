package live.zema.ecommerce.validator;

import live.zema.ecommerce.model.UserDto;
import live.zema.ecommerce.util.Constants;
import org.springframework.stereotype.Component;

/**
 * @author danielniguse
 */

@Component
public class UserValidator {

    public String validate(UserDto userDto) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!userDto.getEmail().matches(regex)) {
            return "Invalid email ";
        }
        if (userDto.getPassword().length() <= Constants.MIN_NUMS_PASSWORD || userDto.getPassword().length() >= Constants.MAX_NUMS_PASSWORD) {
            return ("The password should be between greater than " + Constants.MIN_NUMS_PASSWORD +
                    " and less than " + Constants.MAX_NUMS_PASSWORD);
        }
        return null;
    }
}
