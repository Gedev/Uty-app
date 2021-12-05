package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomReservationDTO {
    private long id;
    private long professor_id;
    private String room_num;
    private int start_time;
    private int end_time;

    private ClassroomReservationDTO.ProfessorDTO professor;

    @Data
    @Builder
    public static class ProfessorDTO {
        private String username;
    }
}
