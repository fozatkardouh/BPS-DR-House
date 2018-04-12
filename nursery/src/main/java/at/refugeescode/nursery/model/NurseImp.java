package at.refugeescode.nursery.model;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class NurseImp implements Nurse {

    @Override
    public void treat(Patient patient) {
        String illness = patient.getIllness();
        log.info("Treating " + patient.getName() + " who has " + illness + " with the medicines");
    }

}
