package ma.zakaria.spring.springprojettp.repository;

import ma.zakaria.spring.springprojettp.entité.Consultation;
import ma.zakaria.spring.springprojettp.entité.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {


}
