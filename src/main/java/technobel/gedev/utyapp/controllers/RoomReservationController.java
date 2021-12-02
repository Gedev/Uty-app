package technobel.gedev.utyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.repository.ClassroomReservationRepository;
import technobel.gedev.utyapp.services.spec.ClassroomReservationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/classrooms_reservation")
public class RoomReservationController {

    private final ClassroomReservationService service;

    public RoomReservationController(ClassroomReservationService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomReservationDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<ClassroomReservationDTO>> getAll(){
        List<ClassroomReservationDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

}


//
//    @GetMapping("/all")
//    public Page<ClassroomReservation> getAllPosts(Pageable pageable) {
//        return classroomReservationRepository.findAll(pageable);
//    }
//
//    @PostMapping("/add")
//    public ClassroomReservation createPost(@Valid @RequestBody ClassroomReservation room_reservation) {
//        return classroomReservationRepository.save(room_reservation);
//    }
