package technobel.gedev.utyapp.models.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Data
@Validated
public class ProfessorForm {
    @Length(min = 2, max = 25)
    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private Date birthdate;

    private Date hire_date;
}
