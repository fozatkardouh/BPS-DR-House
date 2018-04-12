package at.refugeescode.accountancy.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;

@Component
public class AccountantImp implements Accountant {

    private HashMap<String, Double> billRepo = new HashMap<>();

    @Override
    public void calculateBill(Patient patient) {
        Double bill = billRepo.get(patient.getTreatment());
        patient.setBill(bill);
        patient.setLocalDateTime(LocalDateTime.now());
    }

    public void addToBillRepo(String treatment, Double fee) {
        billRepo.put(treatment, fee);
    }

}
