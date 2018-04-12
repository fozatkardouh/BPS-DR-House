package at.refugeescode.drhouse.model;

import lombok.Data;

import java.util.List;

@Data
public class Patient {

    private String uuid;
    private String name;
    private List<String> symptoms;
    private String illness;

    public Patient(String uuid, String name, List<String> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
        this.uuid = uuid;
    }

}
