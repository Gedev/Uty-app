package technobel.gedev.utyapp.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.gedev.utyapp.exceptions.models.ElementNotFoundException;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.RoomEquipment;
import technobel.gedev.utyapp.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
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
//        saveRoomEquipment();
//
//        saveProfessors("Alex", "Doe", "alex", "pass");
//        saveProfessors("Ingrid", "Doe", "Ingrid", "pass");
//        saveProfessors("Frédérique", "Doe", "Frederique", "pass");
//        saveProfessors("Simon", "Doe", "Simon", "pass");
//        saveProfessors("Gregory", "Doe", "Greg", "pass");
//
//        saveClassrooms("121", (short)30);
//        saveClassrooms("123", (short)50);
//        saveClassrooms("001", (short)20);
//        saveClassrooms("002", (short)300);

    }

    public void saveProfessors(String firstname, String lastname, String username, String password) {
        Professor prof = new Professor();
        prof.setFirstname(firstname);
        prof.setLastname(lastname);
        prof.setUsername(username);
        prof.setPassword(encoder.encode(password));
        prof.setBirthdate(new Date(1990, 12, 20));
        professorRepository.save(prof);
    }

    /*
    CLASSROOMS
        String room_num;
        int surface;
     */
    public void saveClassrooms(String room_num, short capacity){
        RoomEquipment re1 = eqRepository.findById(4L).orElseThrow(ElementNotFoundException::new);
        RoomEquipment re2 = eqRepository.findById(2L).orElseThrow(ElementNotFoundException::new);

        System.out.println("re1 " + re1);
        System.out.println("re2" + re2);

        Classroom cl = new Classroom();
        cl.setRoom_num(room_num);
        cl.setSurface(capacity);
        cl.setRoomEquipments(Set.of(re1, re2));
        classroomRepository.save( cl );

//        cl = new Classroom();
//        cl.setRoom_num("104");
//        cl.setSurface(50);
//        cl.setRoomEquipments(Set.of(re1));
//        classroomRepository.save( cl );

//        cl = new Classroom();
//        cl.setRoom_num("104");
//        cl.setSurface(45);
//        cl.setRoomEquipments(Set.of(re2));
//        classroomRepository.save( cl );

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
        clr.setDate(LocalDate.of(2021, 12, 22));
        clr.setStart_time(LocalTime.of(10,30, 0));
        clr.setEnd_time(LocalTime.of(12,30, 0));
        clr.setRoomEquipments(List.of(re1));
        clrRepository.save( clr );
    }
}
