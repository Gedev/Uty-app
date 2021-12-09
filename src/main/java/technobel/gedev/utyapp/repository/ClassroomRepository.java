package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technobel.gedev.utyapp.models.entity.Classroom;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    @Query(value = "SELECT * FROM classroom c WHERE c.id = CAST(room_num AS integer)", nativeQuery = true)
    List<Classroom> searchClassroom(long id);
}