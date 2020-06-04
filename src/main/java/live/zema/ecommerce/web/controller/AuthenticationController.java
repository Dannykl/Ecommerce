package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.util.JwtUtil;
import live.zema.ecommerce.web.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * @author danielniguse
 */
@RestController
public class AuthenticationController {

    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception(ex + "invalid email or password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }
}
