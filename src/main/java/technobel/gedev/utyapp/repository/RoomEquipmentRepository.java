package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.gedev.utyapp.models.entity.RoomEquipment;

public interface RoomEquipmentRepository extends JpaRepository<RoomEquipment, Long> {
}
