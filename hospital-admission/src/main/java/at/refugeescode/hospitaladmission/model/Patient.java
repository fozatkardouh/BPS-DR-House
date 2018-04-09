package at.refugeescode.hospitaladmission.model;

import lombok.Data;

import java.util.List;

import static java.util.UUID.randomUUID;

@Data
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

}
