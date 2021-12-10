package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.mapper.ClassroomMapper;
import technobel.gedev.utyapp.models.dto.ClassroomDTO;
import technobel.gedev.utyapp.repository.ClassroomRepository;
import technobel.gedev.utyapp.services.spec.ClassroomService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository, ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
        this.classroomMapper = classroomMapper;
    }

    // TODO
    @Override
    public ClassroomDTO getOne(Long id) {
        return classroomRepository.findById(id)
                .map(classroomMapper::toDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public Set<ClassroomDTO> getAll() {
        return classroomRepository.findAll()
                .stream()
                .map(classroomMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ClassroomDTO> searchRooms(Long id) {
        return classroomRepository.searchClassroom(id)
                .stream()
                .map(classroomMapper::toDto)
                .collect(Collectors.toSet());
    }
}
