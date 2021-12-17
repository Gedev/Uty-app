package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.RoomEquipmentDTO;

import java.util.List;


public interface EquipmentService {

    RoomEquipmentDTO getOne(Long id);

    List<RoomEquipmentDTO> getAll();
}
