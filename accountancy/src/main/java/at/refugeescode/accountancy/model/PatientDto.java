package at.refugeescode.accountancy.model;

import lombok.Data;

import java.util.List;

@Data
public class PatientDto {

    private String uuid;
    private String name;
    private List<String> symptoms;
    private String illness;
    private String treatment;

}
