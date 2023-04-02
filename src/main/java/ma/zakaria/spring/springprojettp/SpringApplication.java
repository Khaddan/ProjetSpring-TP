package ma.zakaria.spring.springprojettp;

import ma.zakaria.spring.springprojettp.entité.Patient;
import ma.zakaria.spring.springprojettp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringApplication  implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Hamza", new Date("13/03/2000"),true,80));
        patientRepository.save(new Patient(null,"Zakaria",new Date("01/02/1999"),false,60));
        patientRepository.save(new Patient(null,"Hamdi",new Date("20/03/1994"),true,55));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        Patient patient=patientRepository.findById(Long.valueOf(1)).get();
        System.out.println("**********************");
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getDateNaissance());
        System.out.println("***********************");


    }

}
