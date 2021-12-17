package technobel.gedev.utyapp.services.impl;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.mapper.EquipmentMapper;
import technobel.gedev.utyapp.models.dto.RoomEquipmentDTO;
import technobel.gedev.utyapp.repository.RoomEquipmentRepository;
import technobel.gedev.utyapp.services.spec.EquipmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final RoomEquipmentRepository equipmentRepository;
    private final EquipmentMapper mapper;

    public EquipmentServiceImpl(RoomEquipmentRepository equipmentRepository, EquipmentMapper mapper) {
        this.equipmentRepository = equipmentRepository;
        this.mapper = mapper;
    }

    @Override
    public RoomEquipmentDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<RoomEquipmentDTO> getAll() {
        return equipmentRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
