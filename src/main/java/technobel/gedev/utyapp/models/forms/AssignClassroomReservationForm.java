package technobel.gedev.utyapp.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;


@Data
@Validated
public class AssignClassroomReservationForm {

    @NotNull
    Long classroomId;
}
