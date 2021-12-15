package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.forms.ClassroomAssignmentForm;

import java.util.List;

public interface ClassroomReservationService {

    ClassroomReservationDTO getOne(Long id);

    List<ClassroomReservationDTO> getAll();

    List<ClassroomReservationDTO> getAllPendingReservations(boolean status);

    ClassroomReservationDTO delete(Long id);

}
