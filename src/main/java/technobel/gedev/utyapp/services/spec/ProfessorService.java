package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ProfessorDTO;

import java.util.List;

public interface ProfessorService {

    ProfessorDTO getOne(Long id);

    List<ProfessorDTO> getAll();
}
