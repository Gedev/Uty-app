package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.RoomEquipmentDTO;
import technobel.gedev.utyapp.models.entity.RoomEquipment;

@Service
public class EquipmentMapper {
    public RoomEquipmentDTO toDto(RoomEquipment equipmentEntity) {

        if(equipmentEntity == null)
            return null;

        return RoomEquipmentDTO.builder()
                .id(equipmentEntity.getId())
                .name(equipmentEntity.getName())
                .build();
    }
}
