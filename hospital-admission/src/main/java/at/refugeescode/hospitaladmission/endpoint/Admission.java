package at.refugeescode.drhouse.endpoint;

import at.refugeescode.hospitaladmission.model.Patient;
import at.refugeescode.hospitaladmission.model.Patientdto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping
public class Admission {

    private RestTemplate restTemplate;

    private String url = "http://localhost:9052/entry";

    @PostMapping("/patients")
    Patientdto admitNew(@RequestBody Patientdto patientdto) {
        Patient patient = new Patient(patientdto.getName(), patientdto.getSymptoms());
        restTemplate.postForEntity(url, patient, Patient.class);
        return patientdto;
    }

    @GetMapping("/patients")
    Patientdto test(Patientdto patientdto) {
        patientdto.setName("Fozat");
        patientdto.setSymptoms(Arrays.asList("11", "22"));
        return patientdto;
    }

}
