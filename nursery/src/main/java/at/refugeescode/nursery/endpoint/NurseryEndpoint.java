package at.refugeescode.nursery.endpoint;

import at.refugeescode.nursery.model.Nurse;
import at.refugeescode.nursery.model.Patient;
import at.refugeescode.nursery.model.PatientDto;
import at.refugeescode.nursery.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class NurseryEndpoint {

    private final PatientRepository patientRepository;
    private final RestTemplate restTemplate;
    private final Nurse nurse;

    @Value("${accountant.url}")
    private String url;

    @PostMapping
    public PatientDto treat(@RequestBody PatientDto patientDto) {
        Patient patient = Patient.builder()
                .uuid(patientDto.getUuid())
                .illness(patientDto.getIllness())
                .name(patientDto.getName())
                .symptoms(patientDto.getSymptoms())
                .build();
        String treatment = nurse.treat(patient);
        patient.setTreatment(treatment);
        patientRepository.save(patient);
        restTemplate.postForEntity(url, patient, Boolean.class);
        return patientDto;
    }

    @GetMapping
    public Patient test() {
        return Patient.builder()
                .uuid("isdfsh435-lwnernl7w4z7")
                .symptoms(new ArrayList<>())
                .name("fozat")
                .illness("cold")
                .build();
    }

}

