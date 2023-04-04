package ma.zakaria.spring.springprojettp.repository;

import ma.zakaria.spring.springprojettp.entité.Patient;
import ma.zakaria.spring.springprojettp.entité.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {


}
