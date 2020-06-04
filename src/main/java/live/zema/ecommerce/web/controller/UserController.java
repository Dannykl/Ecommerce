package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.UserService;
import live.zema.ecommerce.web.model.SignupResponse;
import live.zema.ecommerce.web.model.UserDto;
import live.zema.ecommerce.web.security.PasswordConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @author danielniguse
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;
    private final PasswordConfig passwordConfig;


    //sign-up
    @PostMapping(path = "/registration")
    ResponseEntity<?> signUp(@RequestBody UserDto userData) {

        Optional<UserDto> user = userService.findByEmail(userData.getEmail());
        if (!user.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(userData.getEmail() + " is already exists on our system");
        }
        //TODO
        //user validator eg. email, length of password
        //UserValidator.validate(userData);
        SignupResponse  signupResponse = userService.save(userData);
        return new ResponseEntity(signupResponse, HttpStatus.CREATED);
    }

    //TODO TO BE REMOVED
    @PostMapping(path = "/login")
    ResponseEntity<?> logIn(@RequestBody Map<String, String> userData) {

        Optional<UserDto> userDto = userService.findByEmail(userData.get("email"));
        UserDto userDtoResult;
        if (userDto.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(userData.get("email") + " was not found ");
        }
        boolean found = passwordConfig.checkPassword(userData.get("password"), userDto.get().getPassword());

        if (!found) {
            return ResponseEntity.badRequest()
                    .body("Incorrect password ");
        }
        userDtoResult = new UserDto(userDto.get().getEmail(),"",null,userDto.get().getOrders(),userDto.get().getCreatedDate());
        return new ResponseEntity(userDtoResult, HttpStatus.OK);
    }


    //TODO
    //createUser =>  this could only be used by admin/user
    //getAllUsers => this could only be used by admin
    //updateUser => this could only be used by admin/user
    //deleteUser => this could only be used by admin/user

}
