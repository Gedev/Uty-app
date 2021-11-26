package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.gedev.utyapp.models.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}