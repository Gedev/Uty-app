package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.gedev.utyapp.models.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}