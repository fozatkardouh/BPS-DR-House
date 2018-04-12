package at.refugeescode.nursery.initialise;

import at.refugeescode.nursery.model.Nurse;
import at.refugeescode.nursery.model.NurseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Starter {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Nurse nurse(NurseImp nurseImp) {
        nurseImp.addTreatment("cold", "cold medicine");
        nurseImp.addTreatment("diarrhea", "diarrhea medicine");
        nurseImp.addTreatment("pruritus", "pruritus medicine");
        nurseImp.addTreatment("lubus", "lubus medicine");
        return nurseImp;
    }

}
