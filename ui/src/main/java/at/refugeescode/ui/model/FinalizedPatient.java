package at.refugeescode.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalizedPatient {

    private Long id;
    private String uuidInMongoDB;
    private String name;
    private List<String> symptoms;
    private String illness;
    private String treatment;
    private Double bill;
    private LocalDateTime localDateTime;

}
