package at.refugeescode.drhouse.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.UUID.randomUUID;

@Data
@Component
public class Patientdto {

    private String uuid;
    private String name;
    private List<String> symptoms;

    public Patientdto() {
        uuid = randomUUID().toString();
    }

    public Patientdto(String name, List<String> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
        uuid = randomUUID().toString();
    }

}
