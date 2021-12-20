package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.forms.AssignClassroomReservationForm;
import technobel.gedev.utyapp.models.forms.SearchClassroomForm;
import technobel.gedev.utyapp.models.forms.ClassroomReservationForm;
import technobel.gedev.utyapp.services.spec.ClassroomReservationService;
import technobel.gedev.utyapp.services.spec.ClassroomService;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<ClassroomReservationDTO>> getAllPendingReservations(boolean status) {
        return ResponseEntity.ok(classroomReservationService.getAllPendingReservations(status));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ClassroomReservationDTO> insert(@Valid @RequestBody ClassroomReservationForm form) {
        return ResponseEntity.ok(classroomReservationService.create(form));
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<ClassroomDTO>> searchRooms(@Valid @RequestBody SearchClassroomForm searchClassroomForm) {
        return ResponseEntity.ok(classroomService.searchClassroom(searchClassroomForm));
    }

    @PatchMapping(path = { "/assignClassroom" }, params = {"reservId"})
    public ResponseEntity<ClassroomReservationDTO> assignClassroom(@RequestParam Long reservId, @RequestBody AssignClassroomReservationForm form) {
        System.out.println("AssignClassroom");
        return ResponseEntity.ok(classroomReservationService.assignClassroom(reservId, form));
    }
}
