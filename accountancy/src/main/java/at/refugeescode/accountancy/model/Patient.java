package at.refugeescode.accountancy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String uuidInMongoDB;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> symptoms;
    private String illness;
    private String treatment;
    private Double bill;
    private LocalDateTime localDateTime;

}
