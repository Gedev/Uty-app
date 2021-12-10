package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.gedev.utyapp.models.entity.Classroom;

import java.util.Set;

@Data
@Builder
public class RoomEquipmentDTO {

    private Long id;
    boolean has_whiteboard;
    boolean has_blackboard;
    boolean has_projector;
    boolean has_professor_pc;
    int students_pc;
    boolean has_interactive_whiteboard;
    boolean has_speakers;

    private Set<Classroom> classrooms;
}
