package med.clinimed.api.controller;

import jakarta.validation.Valid;
import med.clinimed.api.patient.Patient;
import med.clinimed.api.patient.PatientData;
import med.clinimed.api.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;


    @PostMapping
    @Transactional
    public void insertDoctor(@RequestBody @Valid PatientData data) {
        repository.save(new Patient(data));
    }

}
