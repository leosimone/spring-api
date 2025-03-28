package med.clinimed.api.controller;

import jakarta.validation.Valid;
import med.clinimed.api.doctor.Doctor;
import med.clinimed.api.doctor.DoctorData;
import med.clinimed.api.doctor.DoctorListData;
import med.clinimed.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DoctorListData> doctorList(Pageable page) {
        return repository.findAll(page).map(DoctorListData::new);
    }

}
