package technobel.gedev.utyapp.services.spec;

import technobel.gedev.utyapp.models.dto.ProfessorDTO;
import technobel.gedev.utyapp.models.forms.ProfessorForm;

import java.util.List;

public interface ProfessorService {

    ProfessorDTO getOne(Long id);

    List<ProfessorDTO> getAll();

    ProfessorDTO insert(ProfessorForm form);
}
