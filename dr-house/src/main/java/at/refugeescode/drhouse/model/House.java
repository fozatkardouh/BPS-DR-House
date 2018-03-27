package at.refugeescode.drhouse.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class House implements Doctor {

    private HashMap<String, String> diseases = new HashMap<>();

    @Override
    public String diagnose(Patient patient) {
        Optional<String> optionalIllness = patient.getSymptoms().stream()
                .map(s -> diseases.get(s))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        return optionalIllness.orElse("lubus");
    }

    public void addNewIllness(String illnessSymptom, String illness) {
        diseases.put(illnessSymptom, illness);
    }

}
