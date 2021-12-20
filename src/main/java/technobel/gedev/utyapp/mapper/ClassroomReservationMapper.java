package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.dto.RoomEquipmentDTO;
import technobel.gedev.utyapp.models.entity.Classroom;
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
        System.out.println("clrEntity.getDate : " + clrEntity.getDate());
        return ClassroomReservationDTO.builder()
                .id(clrEntity.getId())
                .start_time(clrEntity.getStart_time())
                .end_time(clrEntity.getEnd_time())
                .date(clrEntity.getDate())
                .professor(toInnerDTO(clrEntity.getProfessor()))
                .status(clrEntity.isStatus())
                .classroom(toInnerDTO(clrEntity.getClassroom()))
                .equipments(clrEntity.getRoomEquipments()
                        .stream()
                        .map(this::toInnerDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    private ClassroomReservationDTO.ClassroomDTO toInnerDTO(Classroom entity) {
        if( entity == null)
            return null;

        return ClassroomReservationDTO.ClassroomDTO.builder()
                .id(entity.getId())
                .room_num(entity.getRoom_num())
                .surface(entity.getSurface())
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
        entity.setRoomType_id(form.getRoomTypeId());
        entity.setDate(form.getDate());
        entity.setSize(form.getSize());
        entity.setStart_time(form.getStartTime());
        entity.setEnd_time(form.getEndTime());
        entity.setStatus(true);

        return entity;
    }
}
