package technobel.gedev.utyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.repository.ClassroomReservationRepository;

import javax.validation.Valid;

@RestController
public class RoomReservationController {

    @Autowired
    private ClassroomReservationRepository classroomReservationRepository;

    @GetMapping("/room_reservations")
    public Page<ClassroomReservation> getAllPosts(Pageable pageable) {
        return classroomReservationRepository.findAll(pageable);
    }

    @PostMapping("/room_reservations")
    public ClassroomReservation createPost(@Valid @RequestBody ClassroomReservation room_reservation) {
        return classroomReservationRepository.save(room_reservation);
    }
}
