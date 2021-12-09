package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ClassroomDTO;

import java.util.List;

public interface ClassroomService {

    ClassroomDTO getOne(Long id);

    List<ClassroomDTO> getAll();

    List<ClassroomDTO> searchRooms(Long id);
}


