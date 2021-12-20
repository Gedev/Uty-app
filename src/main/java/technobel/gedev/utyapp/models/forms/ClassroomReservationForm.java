package technobel.gedev.utyapp.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Validated
public class ClassroomReservationForm {

    int roomTypeId;

    @NotNull
    long reservedByProfessorId;

    @NotNull
    LocalDate date;

    @NotNull
    LocalTime startTime;

    @NotNull
    LocalTime endTime;

    @Min(0) @Max(300)
    short size;

    List<Long> roomEquipment;
}
