package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.mapper.ClassroomReservationMapper;
import technobel.gedev.utyapp.models.dto.ClassroomReservationDTO;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.RoomEquipment;
import technobel.gedev.utyapp.models.forms.AssignClassroomReservationForm;
import technobel.gedev.utyapp.models.forms.ClassroomReservationForm;
import technobel.gedev.utyapp.repository.ClassroomRepository;
import technobel.gedev.utyapp.repository.ClassroomReservationRepository;
import technobel.gedev.utyapp.repository.ProfessorRepository;
import technobel.gedev.utyapp.repository.RoomEquipmentRepository;
import technobel.gedev.utyapp.services.spec.ClassroomReservationService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomReservationServiceImpl implements ClassroomReservationService {

    private final ClassroomReservationRepository clrRepository;
    private final ClassroomRepository classroomRepository;
    private final ClassroomReservationMapper clrMapper;
    private final ProfessorRepository professorRepository;
    private final RoomEquipmentRepository roomEquipmentRepository;

    public ClassroomReservationServiceImpl(ClassroomReservationRepository clrRepository, ClassroomRepository classroomRepository, ClassroomReservationMapper clrMapper, ProfessorRepository professorRepository, RoomEquipmentRepository roomEquipmentRepository) {
        this.clrRepository = clrRepository;
        this.classroomRepository = classroomRepository;
        this.clrMapper = clrMapper;
        this.professorRepository = professorRepository;
        this.roomEquipmentRepository = roomEquipmentRepository;
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
    public ClassroomReservationDTO create(@Valid ClassroomReservationForm form) {
        ClassroomReservation clReserv = clrMapper.formtoEntity(form);
        Professor professor = professorRepository.findById(form.getReservedByProfessorId())
                .orElseThrow(ElementNotFoundException::new);
        clReserv.setProfessor( professor );
        List<RoomEquipment> roomEquipmentList = form.getRoomEquipment()
                .stream()
                .map(id -> roomEquipmentRepository.findById(id)
                        .orElseThrow(ElementNotFoundException::new)).toList();
        clReserv.setRoomEquipments(roomEquipmentList);
        clReserv.setStatus(false);
        return clrMapper.toDto( clrRepository.save(clReserv) );
    }

    @Override
    public List<ClassroomReservationDTO> getAllPendingReservations(boolean status) {
        return clrRepository.getAllPendingReservations(status)
                .stream()
                .map(clrMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomReservationDTO assignClassroom(Long reservation_id, AssignClassroomReservationForm form) {
        Classroom classroom = classroomRepository.findById(form.getClassroomId())
                .orElseThrow(ElementNotFoundException::new);
        ClassroomReservation clReserv = clrRepository.findById(reservation_id)
                .orElseThrow(ElementNotFoundException::new);

        clReserv.setClassroom(classroom);
        clReserv.setStatus(true);
        return  clrMapper.toDto( clrRepository.save(clReserv));
    }

    @Override
    public ClassroomReservationDTO delete(Long id) {
        return null;
    }
}
