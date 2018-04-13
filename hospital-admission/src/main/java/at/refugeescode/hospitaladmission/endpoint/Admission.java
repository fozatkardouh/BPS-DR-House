package at.refugeescode.hospitaladmission.endpoint;

import at.refugeescode.hospitaladmission.model.Patient;
import at.refugeescode.hospitaladmission.model.Patientdto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Admission {

    private final RestTemplate restTemplate;

    @Value("${house.url}")
    private String url;

    @PostMapping("/patients")
    public Patient admitNew(@RequestBody Patientdto patientdto) {
        Patient patient = new Patient(patientdto.getName(), patientdto.getSymptoms());
        ResponseEntity<Patient> patientResponseEntity = restTemplate.postForEntity(url, patient, Patient.class);
        return patientResponseEntity.getBody();
    }

    @GetMapping("/patients")
    Patientdto test(Patientdto patientdto) {
        patientdto.setName("Fozat");
        patientdto.setSymptoms(Collections.singletonList("coughing"));
        return patientdto;
    }

}
