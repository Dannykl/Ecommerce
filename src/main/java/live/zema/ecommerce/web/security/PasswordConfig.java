package live.zema.ecommerce.web.security;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Configuration;

/**
 * @author danielniguse
 */
@Configuration
public class PasswordConfig {
    //TODO TO BE REMOVED
    public String hashPassword(String userPassword) {
        return BCrypt.hashpw(userPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(String userPassword, String hashedPassword) {
        return BCrypt.checkpw(userPassword, hashedPassword);
    }
}