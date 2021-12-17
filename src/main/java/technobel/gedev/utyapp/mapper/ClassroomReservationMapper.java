package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.dto.RoomEquipmentDTO;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.RoomEquipment;
import technobel.gedev.utyapp.models.forms.ClassroomReservationForm;

import java.util.stream.Collectors;

@Service
public class ClassroomReservationMapper {
    public ClassroomReservationDTO toDto(ClassroomReservation clrEntity) {
        if (clrEntity == null)
            return null;
        System.out.println(clrEntity);
        return ClassroomReservationDTO.builder()
                .id(clrEntity.getId())
                .room_num(clrEntity.getRoom_num())
                .start_time(clrEntity.getStart_time())
                .end_time(clrEntity.getEnd_time())
                .professor(toInnerDTO(clrEntity.getProfessor()))
                .status(clrEntity.isStatus())
                .equipments(clrEntity.getRoomEquipments()
                        .stream()
                        .map(this::toInnerDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    private ClassroomReservationDTO.ProfessorDTO toInnerDTO(Professor entity) {
        if( entity == null )
            return null;

        return ClassroomReservationDTO.ProfessorDTO.builder()
                .id(entity.getId())
                .username( entity.getUsername() )
                .firstname(entity.getFirstname())
                .lastname( entity.getLastname())
                .birthdate( entity.getBirthdate())
                .build();
    }

    private RoomEquipmentDTO toInnerDTO(RoomEquipment entity) {
        if( entity == null )
            return null;

        return RoomEquipmentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public ClassroomReservation formtoEntity(ClassroomReservationForm form) {
        if(form == null)
            return null;

        ClassroomReservation entity = new ClassroomReservation();
        entity.setDate(form.getDate());
        entity.setStart_time(form.getStart_time());
        entity.setEnd_time(form.getEnd_time());

        return entity;
    }
}
