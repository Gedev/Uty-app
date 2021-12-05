package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.Professor;

@Service
public class ClassroomReservationMapper {
    public ClassroomReservationDTO toDto(ClassroomReservation clrEntity) {
        if (clrEntity == null)
            return null;

        return ClassroomReservationDTO.builder()
                .id(clrEntity.getId())
                .room_num(clrEntity.getRoom_num())
                .start_time(clrEntity.getStart_time())
                .end_time(clrEntity.getEnd_time())
                .professor(toInnerDTO(clrEntity.getProfessor()))
                .build();
    }

    private ClassroomReservationDTO.ProfessorDTO toInnerDTO(Professor entity){
        if( entity == null )
            return null;

        return ClassroomReservationDTO.ProfessorDTO.builder()
                .username( entity.getUsername() )
                .build();
    }
}
