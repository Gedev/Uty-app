package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ClassroomDTO;

import java.util.List;
import java.util.Set;

public interface ClassroomService {

    ClassroomDTO getOne(Long id);

    Set<ClassroomDTO> getAll();

    Set<ClassroomDTO> searchRooms(Long id);
}


