package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.services.spec.ClassroomReservationService;
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
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/assignment", params = "status")
    public ResponseEntity<List<ClassroomReservationDTO>> getAllPendingReservations(boolean status){
        return ResponseEntity.ok(service.getAllPendingReservations(status));
    }
}
