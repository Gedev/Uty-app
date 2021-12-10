package technobel.gedev.utyapp.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.RoomEquipment;
import technobel.gedev.utyapp.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@Component
public class DatabaseFiller implements InitializingBean {

    private final ClassroomRepository classroomRepository;
    private final ClassroomReservationRepository clrRepository;
    private final RoomEquipmentRepository eqRepository;

    public DatabaseFiller(StudentRepository studentRepository, PasswordEncoder encoder, ProfessorRepository professorRepository, ClassroomRepository classroomRepository, ClassroomReservationRepository clrRepository, RoomEquipmentRepository eqRepository) {
        this.classroomRepository = classroomRepository;
        this.clrRepository = clrRepository;
        this.eqRepository = eqRepository;
    }

    @Override
    public void afterPropertiesSet() {
        saveClassrooms();
        saveClassroomsReservations();
        saveRoomEquipment();
    }

    /*
    CLASSROOMS
        String room_num;
        int surface;
     */
    public void saveClassrooms(){
//        Classroom cl = new Classroom();
//        cl.setRoom_num("001");
//        cl.setSurface(15);
//        classroomRepository.save( cl );
//
//        RoomEquipment re1 = new RoomEquipment();
//        re1.setName("projector");
//        re1.setId(4L);
//
//
//        cl = new Classroom();
//        cl.setRoom_num("101");
//        cl.setSurface(25);
//        cl.setRoomEquipments(Set.of(re1));
//        classroomRepository.save( cl );

    }

    public void saveRoomEquipment(){
//        RoomEquipment re = new RoomEquipment();
//        re.setName("blackboard");
//        eqRepository.save( re );
//
//        re = new RoomEquipment();
//        re.setName("whiteboard");
//        eqRepository.save( re );
//
//        re = new RoomEquipment();
//        re.setName("interactive_whiteboard");
//        eqRepository.save( re );
//
//        re = new RoomEquipment();
//        re.setName("projector");
//        eqRepository.save( re );
//
//        re = new RoomEquipment();
//        re.setName("professor_personal_pc");
//        eqRepository.save( re );
//
//        re = new RoomEquipment();
//        re.setName("students_personal_pc");
//        eqRepository.save( re );
//
//        re = new RoomEquipment();
//        re.setName("speakers");
//        eqRepository.save( re );
    }

    public void saveClassroomsReservations() {
//        ClassroomReservation clr = new ClassroomReservation();
//        clr.setRoom_num("101");
//        clr.setStart_time(830);
//        clr.setEnd_time(1030);
//        clrRepository.save( clr );
    }
}
