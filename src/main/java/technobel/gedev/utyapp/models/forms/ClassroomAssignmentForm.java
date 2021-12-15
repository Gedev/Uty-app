package technobel.gedev.utyapp.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class ClassroomAssignmentForm {

    @NotNull
    int id_reservation;

    @NotNull
    String start_time;

    String end_time;

    @NotNull
    List<Long> roomEquipment;
}
