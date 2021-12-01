package technobel.gedev.utyapp.services.spec;

import org.springframework.data.domain.Page;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.forms.StudentForm;

import java.util.List;

public interface StudentService {

    StudentDTO getOne(Long id);

    List<StudentDTO> getAll();

    StudentDTO insert(StudentForm form);

    StudentDTO delete(Long id);

}
