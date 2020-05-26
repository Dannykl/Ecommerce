package live.zema.ecommerce;

import live.zema.configuration.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class EcommerceApplication {

    private Config config;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);

    }

//    public static void main(String[] args) {
//        new SpringApplicationBuilder()
//                .sources(EcommerceApplication.class)
//                .profiles("dev")
//                .run(args);
//    }
//
//    @Bean
//    CommandLineRunner execute() {
//        return args -> config.setup();
//    }


}
