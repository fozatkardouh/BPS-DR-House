package at.refugeescode.drhouse.endpoint;

import at.refugeescode.drhouse.logic.ProcessPatient;
import at.refugeescode.drhouse.model.Patientdto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    void admitNew(@RequestBody Patientdto patientdto) {
        processPatient.processPatient(patientdto);
        //System.out.println(patient.getName() + " has " + patient.getIllness());
    }

}
