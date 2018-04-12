package at.refugeescode.nursery.model;

import lombok.Data;

import java.util.List;

@Data
public class Patient {

    private String uuid;
    private String name;
    private List<String> symptoms;
    private String illness;

}
