package med.clinimed.api.controller;

import jakarta.validation.Valid;
import med.clinimed.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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
    public Page<DoctorListData> doctorList(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        return repository.findAllByActiveTrue(page).map(DoctorListData::new);
    }

    @PutMapping
    @Transactional //JPA detects changes and updates
    public void updateDoctor(@RequestBody @Valid DoctorUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.deleteLogical();
    }

}
