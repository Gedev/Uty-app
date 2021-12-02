package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;

@Service
public class ClassroomReservationMapper {
    public ClassroomReservationDTO toDto(ClassroomReservation clrEntity) {
        if (clrEntity == null)
            return null;

        return ClassroomReservationDTO.builder()
                .id(clrEntity.getId())
                .professor_id(clrEntity.getProfessor().getHire_date())
                .room_num(clrEntity.getRoom_num())
                .start_time(clrEntity.getStart_time())
                .end_time(clrEntity.getEnd_time())
                .professor_id(clrEntity.getProfessor().getId())
                .build();
    }
}
