package ma.zakaria.spring.springprojettp.repository;

import ma.zakaria.spring.springprojettp.entité.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , Long> {
}
