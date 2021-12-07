package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;

import java.util.List;

public interface ClassroomReservationRepository extends JpaRepository<ClassroomReservation, Long> {
    @Query(value = "SELECT * FROM classroom_reservation WHERE status = ?1", nativeQuery = true)
    List<ClassroomReservation> getAllPendingReservations(boolean status);
}
