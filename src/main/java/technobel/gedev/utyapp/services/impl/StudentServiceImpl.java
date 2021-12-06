package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.mapper.StudentMapper;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.entity.Student;
import technobel.gedev.utyapp.models.forms.StudentForm;
import technobel.gedev.utyapp.repository.StudentRepository;
import technobel.gedev.utyapp.services.spec.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public StudentDTO getOne(Long id) {
        return studentRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO insert(StudentForm form) {
        // TODO

        Student studenttoInsert = mapper.formToEntity(form);
        studenttoInsert.setUsername(form.getUsername());
        studenttoInsert.setPassword(form.getPassword());
        studenttoInsert.setFirstname(form.getFirstname());
        studenttoInsert.setLastname(form.getLastname());
        studenttoInsert.setBirthdate(form.getBirthdate());

        studenttoInsert = studentRepository.save(studenttoInsert);

        return mapper.toDto(studenttoInsert);
    }

//    @Override
//    public StudentDTO update(StudentForm form) {
//        // TODO
//        Student toUpdate = studentRepository.findByUsername(form.getUsername())
//                .orElseThrow(ElementNotFoundException::new);
//
//        toUpdate.setUsername(form.getUsername());
//        toUpdate.setPassword(form.getPassword());
//        toUpdate.setFirstname(form.getFirstname());
//        toUpdate.setLastname(form.getLastname());
//        toUpdate.setBirthdate(form.getBirthdate());
//
//        return mapper.toDto(toUpdate);
//    }

    @Override
    public StudentDTO delete(Long id) {
        Student studentToDelete = studentRepository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        studentRepository.delete(studentToDelete);

        return mapper.toDto(studentToDelete);
    }

}
