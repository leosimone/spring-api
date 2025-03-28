package med.clinimed.api.patient;

import med.clinimed.api.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
