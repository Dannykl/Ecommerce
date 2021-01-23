//package live.zema.ecommerce.web.validator;
//
//import live.zema.ecommerce.service.UserService;
//import live.zema.ecommerce.web.model.UserDto;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
///**
// * @author danielniguse
// */
//
//TODO
//@Component
//public class UserValidator implements Validator {
//
//    private UserService userService;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return UserDto.class.equals(aClass);
//    }
//
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        UserDto userDto = (UserDto) o;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
////        if (userDto.getUsername().length() < 6 || userDto.getUsername().length() > 32) {
////            errors.rejectValue("username", "Size.userForm.username");
////        }
////        if (userService.findByUsername(user.getUsername()) != null) {
////            errors.rejectValue("username", "Duplicate.userForm.username");
////        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//        if (userDto.getPassword().length() < 8 || userDto.getPassword().length() > 32) {
//            errors.rejectValue("password", "Size.userForm.password");
//        }
//
////        if (!userDto.getPasswordConfirm().equals(userDto.getPassword())) {
////            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
////        }
//    }
//}
