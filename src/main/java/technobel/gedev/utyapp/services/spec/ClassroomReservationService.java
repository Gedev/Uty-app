package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.forms.AssignClassroomReservationForm;
import technobel.gedev.utyapp.models.forms.ClassroomReservationForm;

import java.util.List;

public interface ClassroomReservationService {

    ClassroomReservationDTO getOne(Long id);

    List<ClassroomReservationDTO> getAll();

    ClassroomReservationDTO create(ClassroomReservationForm form);

    List<ClassroomReservationDTO> getAllPendingReservations(boolean status);

    ClassroomReservationDTO assignClassroom(Long reservation_id, AssignClassroomReservationForm form);

    ClassroomReservationDTO delete(Long id);

}
