package live.zema.configuration;

/**
 * @author danielniguse
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

    @Profile("dev")
    @Bean
    public String devDatabaseConnection() {
        return "DB connection for DEV - local MYSQL";
    }

//    @Profile("test")
//    @Bean
//    public String testDatabaseConnection() {
//        return "DB Connection to not set up yet";
//    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection() {
        return "DB Connection to cloud  MYSQL";
    }
}
