package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.UserService;
import live.zema.ecommerce.web.model.UserDto;
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


    //sign-up
//    @PostMapping
//    ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
//        userDto.
//        return ResponseEntity;
//    }

    private final UserService userService;

    @PostMapping(path = "/login")
    ResponseEntity<?> logIn(@RequestBody Map<String, String> userData) {

        Optional<UserDto> userDto = userService.findByEmail(userData.get("email"));
        System.out.println(userDto);
        System.out.println(userDto);
        if (userDto.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(userData.get("email") + " was not found ");
        }
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    //logIn


    //createUser =>  this could only be used by admin

    //getAllUsers => this could only be used by admin

    //updateUser => this could only be used by admin

    //deleteUser => this could only be used by admin

    //getUser ???
}
