package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.dto.ProfessorDTO;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.forms.ProfessorForm;
import technobel.gedev.utyapp.models.forms.StudentForm;
import technobel.gedev.utyapp.services.spec.ProfessorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<ProfessorDTO>> getAll() {
        List<ProfessorDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public ProfessorDTO insert(@Valid @RequestBody ProfessorForm form) {
        return service.insert(form);
    }
}
