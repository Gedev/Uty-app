package technobel.gedev.utyapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technobel.gedev.utyapp.models.dto.RoomEquipmentDTO;
import technobel.gedev.utyapp.services.spec.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/equipments")
@Validated
public class EquipmentController {

    private EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomEquipmentDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
