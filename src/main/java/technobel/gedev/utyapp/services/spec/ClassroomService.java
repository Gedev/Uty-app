package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.models.forms.SearchClassroomForm;

import java.util.List;
import java.util.Set;

public interface ClassroomService {

    ClassroomDTO getOne(Long id);

    Set<ClassroomDTO> getAll();

    List<ClassroomDTO> searchClassroom(SearchClassroomForm classAssignForm);
}


