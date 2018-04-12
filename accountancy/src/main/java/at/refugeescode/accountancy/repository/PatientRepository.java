package at.refugeescode.accountancy.repository;

import at.refugeescode.accountancy.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
