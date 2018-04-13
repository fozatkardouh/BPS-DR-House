package at.refugeescode.drhouse.logic;

import at.refugeescode.drhouse.model.Doctor;
import at.refugeescode.drhouse.model.Patient;
import at.refugeescode.drhouse.model.Patientdto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProcessPatient {

    private final RestTemplate restTemplate;
    private final Doctor doctor;

    @Value("${nursery.url}")
    private String url;

    public void processPatient(Patientdto patientdto) {
        Patient patient = new Patient(patientdto.getUuid(), patientdto.getName(), patientdto.getSymptoms());
        String illness = doctor.diagnose(patient);
        patient.setIllness(illness);
        restTemplate.postForEntity(url, patient, Patient.class);
    }

}
