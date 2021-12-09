package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.models.entity.Classroom;

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
                .build();
    }
}
