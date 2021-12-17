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

    @NotNull
    long reservedByProfessorId;

    @NotNull
    LocalDate date;

    @NotNull
    LocalTime start_time;

    @NotNull
    LocalTime end_time;

    @Min(1) @Max(300)
    long size;

    @NotNull
    List<Long> roomEquipment;
}
