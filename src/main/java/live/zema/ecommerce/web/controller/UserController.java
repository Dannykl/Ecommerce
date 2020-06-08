package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.UserService;
import live.zema.ecommerce.web.model.SignupResponse;
import live.zema.ecommerce.web.model.UserDto;
import live.zema.ecommerce.web.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;

import java.util.Optional;


/**
 * @author danielniguse
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @PostMapping(path = "/registration")
    ResponseEntity<?> signUp(@RequestBody UserDto userData, BindingResult bindingResult) {

        Optional<UserDto> user = userService.findByEmail(userData.getEmail());
        if (!user.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(userData.getEmail() + " is already exists on our system");
        }
        var validationResult = userValidator.validate(userData);
        if (validationResult!=null) {
            return ResponseEntity.badRequest().body(validationResult);
        }
        SignupResponse  signupResponse = userService.save(userData);
        return new ResponseEntity(signupResponse, HttpStatus.CREATED);
    }



    //TODO
    //createUser =>  this could only be used by admin/user
    //getAllUsers => this could only be used by admin
    //updateUser => this could only be used by admin/user
    //deleteUser => this could only be used by admin/user

}
