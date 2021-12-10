package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.services.spec.ClassroomService;

import java.util.Set;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<Set<ClassroomDTO>> getAll() {
        Set<ClassroomDTO> set = service.getAll();
        return ResponseEntity.ok(set);
    }


}
