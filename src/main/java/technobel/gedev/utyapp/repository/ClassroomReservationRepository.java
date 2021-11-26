package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;

public interface ClassroomReservationRepository extends JpaRepository<ClassroomReservation, Long> {
}
