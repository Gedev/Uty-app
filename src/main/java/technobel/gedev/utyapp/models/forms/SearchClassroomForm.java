package technobel.gedev.utyapp.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Data
@Validated
public class SearchClassroomForm {

    @NotNull
    int id_reservation;

    @NotNull
    LocalTime start_time;

    @NotNull
    LocalTime end_time;

    int size;

    @NotNull
    List<Long> roomEquipment;
}
