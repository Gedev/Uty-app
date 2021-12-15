package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.gedev.utyapp.models.entity.Classroom;

import java.util.Set;

@Data
@Builder
public class RoomEquipmentDTO {

    private Long id;
    String name;

    private Set<Classroom> classrooms;
}
