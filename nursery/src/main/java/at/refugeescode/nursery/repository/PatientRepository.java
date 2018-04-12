package at.refugeescode.nursery.repository;

import at.refugeescode.nursery.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
