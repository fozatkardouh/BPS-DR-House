package at.refugeescode.ui.model;

import lombok.Data;

import java.util.List;

@Data
public class Patient {

    private String name;
    private List<String> symptoms;

}
