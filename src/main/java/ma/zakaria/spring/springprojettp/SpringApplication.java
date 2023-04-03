package ma.zakaria.spring.springprojettp;

import ma.zakaria.spring.springprojettp.entité.Patient;
import ma.zakaria.spring.springprojettp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//@EnableJpaRepositories
@SpringBootApplication
public class SpringApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

        /*

    @PostMapping
    public Patient ajouterPatient(@RequestBody Patient patient) {
        patientRepository.save(new Patient(null,"Hamza", new Date("13/03/2000"),true,80));
        return patientRepository.save(patient);
    }

    @GetMapping
    public List<Patient> consulterPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> consulterPatient(@PathVariable Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Patient> chercherPatients(@RequestParam String nom) {
        return patientRepository.findByNomContaining(nom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> mettreAJourPatient(@PathVariable Long id, @RequestBody Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patient.setId(id);
            return ResponseEntity.ok(patientRepository.save(patient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPatient(@PathVariable Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/


    @Override
    public void  run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Hamza", new Date("13/03/2000"),true,80));
        patientRepository.save(new Patient(null,"Zakaria",new Date("01/02/1999"),false,60));
        patientRepository.save(new Patient(null,"Hamdi",new Date("20/03/1994"),true,55));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        Patient patient=patientRepository.findById(Long.valueOf(3)).get();
        System.out.println("**********************");
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getDateNaissance());
        System.out.println("***********************");
        List<Patient>patientList = patientRepository.findByNomContaining("Zakaria");
        patientList.forEach(p->{
            System.out.println(p);
        } );
        System.out.println("***********************");
        Optional<Patient> patient2 = patientRepository.findById(Long.valueOf(3));
        patient2.ifPresent(p -> {
            p.setMalade(false);
            p.setScore(5);
            patientRepository.save(p);
            System.out.println(p);
        });
        System.out.println("***********************");
        patientRepository.deleteById(3L);
        Patient deletedPatient = patientRepository.findById(3L).orElse(null);
        if (deletedPatient == null) {
            System.out.println("Le patient a été supprimé");
        } else {
            System.out.println("Le patient n'a pas été supprimé");
        }

       // Optional<Patient> deletedPatient = patientRepository.findById(Long.valueOf(1));
       // assertThat(deletedPatient).isNotPresent();

    }


}






