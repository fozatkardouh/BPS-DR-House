package at.refugeescode.drhouse.endpoint;

import at.refugeescode.drhouse.model.Doctor;
import at.refugeescode.drhouse.model.Patient;
import at.refugeescode.drhouse.model.Patientdto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class Admission {

    private RestTemplate restTemplate;
    private Doctor doctor;

    @PostMapping("/patients")
    void admitNew(@RequestBody Patientdto patientdto) {
        Patient patient = new Patient(patientdto.getName(), patientdto.getSymptoms(), patientdto.getUuid());
        String illness = doctor.diagnose(patient);
        patient.setIllness(illness);
        System.out.println(patient.getName() + " has " + patient.getIllness());
    }

}
