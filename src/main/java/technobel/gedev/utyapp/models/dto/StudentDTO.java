package technobel.gedev.utyapp.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StudentDTO {
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private boolean acquitted_of_school_fees;
}
