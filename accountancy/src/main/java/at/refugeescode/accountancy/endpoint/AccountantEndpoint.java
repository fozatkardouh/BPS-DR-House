package at.refugeescode.accountancy.endpoint;

import at.refugeescode.accountancy.model.Accountant;
import at.refugeescode.accountancy.model.Patient;
import at.refugeescode.accountancy.model.PatientDto;
import at.refugeescode.accountancy.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountantEndpoint {

    private final Accountant accountant;
    private final PatientRepository patientRepository;

    @PostMapping
    public Boolean calculateBills(@RequestBody PatientDto patientDto) {
        Patient patient = getPatient(patientDto);
        Double bill = accountant.calculateBill(patient);
        patient.setBill(bill);
        patient.setLocalDateTime(LocalDateTime.now());
        patientRepository.save(patient);
        return true;
    }

    private Patient getPatient(PatientDto patientDto) {
        return Patient.builder()
                .uuidInMongoDB(patientDto.getUuid())
                .illness(patientDto.getIllness())
                .name(patientDto.getName())
                .symptoms(patientDto.getSymptoms())
                .treatment(patientDto.getTreatment())
                .build();
    }

    @GetMapping("/invoices")
    public List<Patient> getAllBills() {
        List<Patient> patients = patientRepository.findAll();
        patients.sort(Comparator.comparing(Patient::getLocalDateTime));
        return patients;
    }

}
