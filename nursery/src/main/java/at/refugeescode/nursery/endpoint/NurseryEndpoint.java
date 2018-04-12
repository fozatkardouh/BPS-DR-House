package at.refugeescode.nursery.endpoint;

import at.refugeescode.nursery.model.Nurse;
import at.refugeescode.nursery.model.Patient;
import at.refugeescode.nursery.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/patients")
public class NurseryEndpoint {

    private final PatientRepository patientRepository;
    private final Nurse nurse;

    @PostMapping
    public Patient treat(Patient patient) {
        nurse.treat(patient);
        patientRepository.save(patient);
        return patient;
    }

}

