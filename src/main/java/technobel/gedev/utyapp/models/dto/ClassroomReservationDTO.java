package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClassroomReservationDTO {
    private long id;
    private String room_num;
    private int start_time;
    private int end_time;
    private boolean status;

    private ClassroomReservationDTO.ProfessorDTO professor;

    @Data
    @Builder
    public static class ProfessorDTO {
        private long id;
        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private Date birthdate;
        private Date hire_date;
    }
}
