package at.refugeescode.drhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
