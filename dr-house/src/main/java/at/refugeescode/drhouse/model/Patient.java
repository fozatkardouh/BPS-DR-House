package at.refugeescode.drhouse.model;

import java.util.List;

public class Patient {

    private String uuid;
    private String name;
    private List<String> symptoms;
    private String illness;

    public Patient(String name, List<String> symptoms, String uuid) {
        this.name = name;
        this.symptoms = symptoms;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

}
