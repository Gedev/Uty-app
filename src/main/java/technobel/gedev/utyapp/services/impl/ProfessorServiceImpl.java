package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.mapper.ProfessorMapper;
import technobel.gedev.utyapp.models.dto.ProfessorDTO;
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

}
