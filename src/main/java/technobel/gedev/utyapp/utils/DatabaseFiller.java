package technobel.gedev.utyapp.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.RoomEquipment;
import technobel.gedev.utyapp.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class DatabaseFiller implements InitializingBean {

    private final ClassroomRepository classroomRepository;
    private final ClassroomReservationRepository clrRepository;
    private final RoomEquipmentRepository eqRepository;
    private final ProfessorRepository professorRepository;
    private final PasswordEncoder encoder;

    public DatabaseFiller(StudentRepository studentRepository, PasswordEncoder encoder, ProfessorRepository professorRepository, ClassroomRepository classroomRepository, ClassroomReservationRepository clrRepository, RoomEquipmentRepository eqRepository, ProfessorRepository professorRepository1, PasswordEncoder encoder1) {
        this.classroomRepository = classroomRepository;
        this.clrRepository = clrRepository;
        this.eqRepository = eqRepository;
        this.professorRepository = professorRepository1;
        this.encoder = encoder1;
    }

    @Override
    public void afterPropertiesSet() {
//        saveClassrooms();
//        saveClassroomsReservations();
//        saveRoomEquipment();
//        saveProfessors();
    }

    public void saveProfessors() {
        Professor prof = new Professor();
        prof.setFirstname("Teddy");
        prof.setLastname("Leloup");
        prof.setUsername("Ted");
        prof.setPassword(encoder.encode("pass"));
//        Date(int year, int month, int day)
        prof.setBirthdate(new Date(2021, 12, 20));
        professorRepository.save(prof);
    }

    /*
    CLASSROOMS
        String room_num;
        int surface;
     */
    public void saveClassrooms(){
        Classroom cl = new Classroom();
        cl.setRoom_num("001");
        cl.setSurface(15);
        classroomRepository.save( cl );

        RoomEquipment re1 = eqRepository.getById(4L);

        cl = new Classroom();
        cl.setRoom_num("102");
        cl.setSurface(25);
        cl.setRoomEquipments(Set.of(re1));
        classroomRepository.save( cl );

    }

    public void saveRoomEquipment(){
        RoomEquipment re = new RoomEquipment();
        re.setName("blackboard");
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setName("whiteboard");
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setName("interactive_whiteboard");
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setName("projector");
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setName("professor_personal_pc");
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setName("students_personal_pc");
        eqRepository.save( re );

        re = new RoomEquipment();
        re.setName("speakers");
        eqRepository.save( re );
    }

    public void saveClassroomsReservations() {
        RoomEquipment re1 = eqRepository.getById(4L);
        ClassroomReservation clr = new ClassroomReservation();
//        Params:
//        year – the year to represent, from MIN_YEAR to MAX_YEAR
//        month – the month-of-year to represent, not null
//        dayOfMonth – the day-of-month to represent, from 1 to 31
//        hour – the hour-of-day to represent, from 0 to 23
//        minute – the minute-of-hour to represent, from 0 to 59
        clr.setStart_time(LocalDateTime.of(2021,12, 22, 10, 30));
        clr.setEnd_time(LocalDateTime.of(2021,12, 22, 12, 30));
        clr.setRoomEquipments(List.of(re1));
        clrRepository.save( clr );
    }
}
