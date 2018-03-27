package at.refugeescode.hospitaladmission.initializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Components {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
