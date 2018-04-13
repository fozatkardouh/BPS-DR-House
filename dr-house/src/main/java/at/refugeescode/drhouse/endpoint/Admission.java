package at.refugeescode.drhouse.endpoint;

import at.refugeescode.drhouse.logic.ProcessPatient;
import at.refugeescode.drhouse.model.Patientdto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Admission {

    private final ProcessPatient processPatient;

    @PostMapping("/patients")
    Patientdto admitNew(@RequestBody Patientdto patientdto) {
        processPatient.processPatient(patientdto);
        return patientdto;
    }

}
