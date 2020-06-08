package live.zema.ecommerce.web.validator;

import live.zema.ecommerce.web.model.UserDto;
import org.springframework.stereotype.Component;

import static live.zema.ecommerce.web.util.Constants.MAX_NUMS_PASSWORD;
import static live.zema.ecommerce.web.util.Constants.MIN_NUMS_PASSWORD;

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
        if (userDto.getPassword().length() <= MIN_NUMS_PASSWORD || userDto.getPassword().length() >= MAX_NUMS_PASSWORD) {
            return ("The password should be between greater than " + MIN_NUMS_PASSWORD +
                    " and less than " + MAX_NUMS_PASSWORD);
        }
        return null;
    }
}
