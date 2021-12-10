package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technobel.gedev.utyapp.models.entity.Classroom;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
//    @Query(value = "SELECT c FROM Classroom c WHERE CAST(c.room_num AS integer) = ?1 ", nativeQuery = true)
    @Query(value = "SELECT * FROM Classroom c WHERE c.room_num = ?1", nativeQuery = true)
    List<Classroom> searchClassroom(long id);
}