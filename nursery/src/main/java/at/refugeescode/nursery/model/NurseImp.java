package at.refugeescode.nursery.model;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Log
@Component
public class NurseImp implements Nurse {

    private HashMap<String, String> treatmentRepo = new HashMap<>();

    @Override
    public void treat(Patient patient) {
        String illness = patient.getIllness();
        String treatment = treatmentRepo.get(patient.getIllness());
        patient.setTreatment(treatment);
        log.info("Treating " + patient.getName() + " who has " + illness + " with " + patient.getTreatment());
    }

    public void addTreatment(String illness, String treatment) {
        this.treatmentRepo.put(illness, treatment);
    }

}
