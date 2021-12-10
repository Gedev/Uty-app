package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.services.spec.ClassroomReservationService;
import technobel.gedev.utyapp.services.spec.ClassroomService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/classrooms_reservation")
public class RoomReservationController {

    private final ClassroomReservationService classroomReservationService;
    private final ClassroomService classroomService;

    public RoomReservationController(ClassroomReservationService service, ClassroomService classroomService) {
        this.classroomReservationService = service;
        this.classroomService = classroomService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomReservationDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(classroomReservationService.getOne(id));
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<ClassroomReservationDTO>> getAll(){
        return ResponseEntity.ok(classroomReservationService.getAll());
    }

    @GetMapping(value = "/assignment", params = "status")
    public ResponseEntity<List<ClassroomReservationDTO>> getAllPendingReservations(boolean status){
        return ResponseEntity.ok(classroomReservationService.getAllPendingReservations(status));
    }

    @GetMapping(value = "/assignment/{id}")
    public ResponseEntity<Set<ClassroomDTO>> searchRooms(@PathVariable long id) {
        return ResponseEntity.ok(classroomService.searchRooms(id));
    }
}
