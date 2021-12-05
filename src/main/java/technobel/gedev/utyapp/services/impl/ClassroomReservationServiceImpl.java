package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.mapper.ClassroomReservationMapper;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.repository.ClassroomReservationRepository;
import technobel.gedev.utyapp.services.spec.ClassroomReservationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomReservationServiceImpl implements ClassroomReservationService {

    private final ClassroomReservationRepository clrRepository;
    private final ClassroomReservationMapper clrMapper;

    public ClassroomReservationServiceImpl(ClassroomReservationRepository clrRepository, ClassroomReservationMapper clrMapper) {
        this.clrRepository = clrRepository;
        this.clrMapper = clrMapper;
    }

    @Override
    public ClassroomReservationDTO getOne(Long id) {
        return clrRepository.findById(id)
                .map(clrMapper::toDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<ClassroomReservationDTO> getAll() {
        return clrRepository.findAll()
                .stream()
                .map(clrMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomReservationDTO delete(Long id) {
        return null;
    }
}
