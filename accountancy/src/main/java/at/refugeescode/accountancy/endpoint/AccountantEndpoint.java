package at.refugeescode.accountancy.endpoint;

import at.refugeescode.accountancy.model.Accountant;
import at.refugeescode.accountancy.model.Patient;
import at.refugeescode.accountancy.model.PatientDto;
import at.refugeescode.accountancy.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountantEndpoint {

    private final Accountant accountant;
    private final PatientRepository patientRepository;

    @PostMapping
    public Patient calculateBills(@RequestBody PatientDto patientDto) {
        Patient patient = getPatient(patientDto);
        accountant.calculateBill(patient);
        patientRepository.save(patient);
        return patient;
    }

    private Patient getPatient(PatientDto patientDto) {
        return Patient.builder()
                    .uuidInMongoDB(patientDto.getUuid())
                    .illness(patientDto.getIllness())
                    .name(patientDto.getName())
                    .symptoms(patientDto.getSymptoms())
                    .build();
    }

    @GetMapping("/invoices")
    public List<Patient> getAllBills() {
        List<Patient> patients = patientRepository.findAll();
        patients.sort(Comparator.comparing(Patient::getLocalDateTime));
        return patients;
    }

}
