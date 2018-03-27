package at.refugeescode.hospitaladmission.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Patientdto {

    private String name;
    private List<String> symptoms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

}
