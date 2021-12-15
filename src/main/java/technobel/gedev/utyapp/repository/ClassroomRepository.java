package technobel.gedev.utyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technobel.gedev.utyapp.models.entity.Classroom;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
        @Query(value = "SELECT  c.id, c.room_num, c.surface FROM classroom c JOIN room_equipment_classrooms r ON c.id = r.classrooms_id WHERE r.room_equipments_id IN ?1 GROUP BY c.id HAVING COUNT (*) = ?2", nativeQuery = true)
        List<Classroom> searchClassroom(List<Long> equipmentIDList, Long listLength);


    // 1. FILTRER : CLASSROOMS ON THE DATE CRITERIA
        // -> VERIFIER SI LA CLASSE EST DISPONIBLE à cette DATE
            // -> SELECT * CLASSROOMS_RESERVATION WHERE DATE BEGINS AT CLASSROOM_RESERVATION DATE
                    // SI 1 entrée, réservation non possible
            // -> SELECT * COURSES_SESSIONS WHERE DATE BEGINS AT 10:30
                    // SI 1 entrée, réservation non possible
    // 2. SELECT : CLASSROOMS WITH LIST_EQUIPMENTS = CLASSROOM_RESERVATION LIST_EQUIPMENT

    // Reprendre la liste d'ID
}