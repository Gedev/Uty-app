package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.RoomEquipment;

import java.util.stream.Collectors;

@Service
public class ClassroomMapper {
    //TODO
    public ClassroomDTO toDto(Classroom clrEntity) {
        if (clrEntity == null)
            return null;
        System.out.println("CLASSROOM ENTITY" + clrEntity);
        return ClassroomDTO.builder()
                .id(clrEntity.getId())
                .room_num(clrEntity.getRoom_num())
                .surface(clrEntity.getSurface())
                .roomEquipmentList(
                        clrEntity.getRoomEquipments()
                                .stream()
                                .map(this::toInnerDTO)
                                .collect(Collectors.toSet())
                )
                .build();
    }

    private ClassroomDTO.RoomEquipmentDTO toInnerDTO(RoomEquipment roomEquipmentEntity){
        if( roomEquipmentEntity == null )
            return null;

        return ClassroomDTO.RoomEquipmentDTO.builder()
                .id(roomEquipmentEntity.getId())
                .name(roomEquipmentEntity.getName())
                .build();
    }
}
