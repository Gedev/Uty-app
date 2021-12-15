package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProfessorDTO {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private Date hire_date;

    private List<ClassroomReservationDTO> reservations;
}
