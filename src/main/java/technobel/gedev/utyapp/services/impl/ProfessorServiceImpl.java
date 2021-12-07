package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.mapper.ProfessorMapper;
import technobel.gedev.utyapp.models.dto.ProfessorDTO;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.Student;
import technobel.gedev.utyapp.models.forms.ProfessorForm;
import technobel.gedev.utyapp.models.forms.StudentForm;
import technobel.gedev.utyapp.repository.ProfessorRepository;
import technobel.gedev.utyapp.services.spec.ProfessorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    @Override
    public ProfessorDTO getOne(Long id) {
        return professorRepository.findById(id)
                .map(professorMapper::toDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<ProfessorDTO> getAll() {
        return professorRepository.findAll()
                .stream()
                .map(professorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO insert(ProfessorForm form) {
        Professor professorToInsert = professorMapper.formToEntity(form);
        professorToInsert.setUsername(form.getUsername());
        professorToInsert.setPassword(form.getPassword());
        professorToInsert.setFirstname(form.getFirstname());
        professorToInsert.setLastname(form.getLastname());
        professorToInsert.setBirthdate(form.getBirthdate());

        professorToInsert = professorRepository.save(professorToInsert);

        return professorMapper.toDto(professorToInsert);
    }

}
