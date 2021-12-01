package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthdate;
}
