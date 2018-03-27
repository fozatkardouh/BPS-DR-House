package at.refugeescode.hospitaladmission.model;

import java.util.List;

import static java.util.UUID.randomUUID;

public class Patient {

    private String uuid;
    private String name;
    private List<String> symptoms;

    public Patient() {
        uuid = randomUUID().toString();
    }

    public Patient(String name, List<String> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
        uuid = randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

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
