package med.clinimed.api.controller;

import jakarta.validation.Valid;
import med.clinimed.api.doctor.Doctor;
import med.clinimed.api.doctor.DoctorData;
import med.clinimed.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void insertDoctor(@RequestBody @Valid DoctorData data) {
        repository.save(new Doctor(data));
    }

}
