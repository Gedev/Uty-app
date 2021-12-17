package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ClassroomReservationDTO {
    private long id;

    @NotNull
    private LocalDate date;

    private String room_num;
    private LocalTime start_time;
    private LocalTime end_time;
    private boolean status;

    private ClassroomReservationDTO.ProfessorDTO professor;

    @Data
    @Builder
    public static class ProfessorDTO {
        private long id;
        private String username;
        private String firstname;
        private String lastname;
        private Date birthdate;
        private Date hire_date;
    }

    private List<RoomEquipmentDTO> equipments;
}
