package at.refugeescode.hospitaladmission.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Patientdto {

    private String name;
    private List<String> symptoms;

}
