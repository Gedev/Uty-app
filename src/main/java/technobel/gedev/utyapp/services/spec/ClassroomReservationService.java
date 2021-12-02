package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.forms.StudentForm;

import java.util.List;

public interface ClassroomReservationService {

    ClassroomReservationDTO getOne(Long id);

    List<ClassroomReservationDTO> getAll();

    ClassroomReservationDTO delete(Long id);

}
