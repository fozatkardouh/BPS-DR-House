package at.refugeescode.accountancy.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AccountantImp implements Accountant {

    private HashMap<String, Double> billRepo = new HashMap<>();

    @Override
    public Double calculateBill(Patient patient) {
        return billRepo.get(patient.getTreatment());
    }

    public void addToBillRepo(String treatment, Double fee) {
        billRepo.put(treatment, fee);
    }

}
