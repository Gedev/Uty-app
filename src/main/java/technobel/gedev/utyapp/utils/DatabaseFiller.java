package technobel.gedev.utyapp.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.RoomEquipment;
import technobel.gedev.utyapp.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        roomEquipment();
    }

    /*
    CLASSROOMS
        int class_num;
        int surface;
     */
    public void saveClassrooms(){
        Classroom cl = new Classroom();
        cl.setRoom_num("1");
        cl.setSurface(20);
        classroomRepository.save( cl );
    }

    public void roomEquipment(){
        RoomEquipment re = new RoomEquipment();
        re.setHas_blackboard(false);
        re.setHas_interactive_whiteboard(true);
        re.setHas_projector(true);
        re.setHas_professor_pc(true);
        re.setHas_speakers(false);
        re.setStudents_pc(0);
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setHas_whiteboard(true);
        re.setHas_blackboard(false);
        re.setHas_interactive_whiteboard(false);
        re.setHas_projector(true);
        re.setHas_professor_pc(true);
        re.setHas_speakers(false);
        re.setStudents_pc(0);
        eqRepository.save( re );
    }

    public void saveClassroomsReservations() {
        ClassroomReservation clr = new ClassroomReservation();
        clr.setRoom_num("101");
        clr.setStart_time(830);
        clr.setEnd_time(1030);
        clrRepository.save( clr );
    }
}
