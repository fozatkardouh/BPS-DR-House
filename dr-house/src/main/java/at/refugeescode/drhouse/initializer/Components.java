package at.refugeescode.drhouse.initializer;

import at.refugeescode.drhouse.model.Doctor;
import at.refugeescode.drhouse.model.House;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Components {

    private House house;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Doctor doctor(House house) {
        house.addNewIllness("coughing", "cold");
        house.addNewIllness("sneezing", "cold");
        house.addNewIllness("stomach ache", "diarrhea");
        house.addNewIllness("itching", "pruritus");
        return house;
    }

}
