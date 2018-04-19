package at.refugeescode.ui.endpoint;

import at.refugeescode.ui.model.Patient;
import at.refugeescode.ui.model.PatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AdmissionEndpoint {

    private final RestTemplate restTemplate;

    @Value("${admission.url}")
    private String admissionURL;

    @GetMapping
    public String home() {
        return "home";
    }

    @ModelAttribute("newPatientDto")
    public PatientDto patientDto() {
        return new PatientDto();
    }

    @PostMapping
    public String Home(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setSymptoms(Arrays.asList(patientDto.getSymptoms().split(", ")));
        restTemplate.postForObject(admissionURL + "/patients", patient, Patient.class);
        return "redirect:/";
    }

}
