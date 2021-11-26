package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.gedev.utyapp.models.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
