package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ProfessorDTO {

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthdate;

    private List<ClassroomReservationDTO> reservations;
}
