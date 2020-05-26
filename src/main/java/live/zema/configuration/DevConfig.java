package live.zema.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author danielniguse
 */
@Component
@Profile("dev")
public class DevConfig implements Config {
    @Override
    public void setup() {
        System.out.println("Development configuration setup");
    }
}
