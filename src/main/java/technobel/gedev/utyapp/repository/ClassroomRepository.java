package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technobel.gedev.utyapp.models.entity.Classroom;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
        @Query(value = "SELECT  c.id, c.room_num, c.surface " +
                "FROM classroom c JOIN room_equipment_classrooms r " +
                "ON c.id = r.classrooms_id WHERE r.room_equipments_id " +
                "IN ?1 " +
                "GROUP BY c.id " +
                "HAVING COUNT (*) = ?2", nativeQuery = true)
        List<Classroom> searchClassroom(List<Long> equipmentIDList, Long listLength);
}

