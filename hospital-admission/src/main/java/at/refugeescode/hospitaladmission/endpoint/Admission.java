package at.refugeescode.hospitaladmission.endpoint;

import at.refugeescode.hospitaladmission.model.Patient;
import at.refugeescode.hospitaladmission.model.Patientdto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Admission {

    private final RestTemplate restTemplate;

    @Value("${entry.url}")
    private String url;

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
