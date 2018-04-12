package at.refugeescode.nursery.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class Patient {

    private String uuid;
    private String name;
    private List<String> symptoms;
    private String illness;
    private String treatment;

}
