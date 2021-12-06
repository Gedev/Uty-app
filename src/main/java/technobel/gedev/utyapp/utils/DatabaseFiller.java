package technobel.gedev.utyapp.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.gedev.utyapp.models.entity.Classroom;
import technobel.gedev.utyapp.models.entity.ClassroomReservation;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.Student;
import technobel.gedev.utyapp.repository.ClassroomRepository;
import technobel.gedev.utyapp.repository.ClassroomReservationRepository;
import technobel.gedev.utyapp.repository.ProfessorRepository;
import technobel.gedev.utyapp.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Date;

@Component
public class DatabaseFiller implements InitializingBean {

    private final StudentRepository studentRepository;
    private final PasswordEncoder encoder;
    private final ProfessorRepository professorRepository;
    private final ClassroomRepository classroomRepository;
    private final ClassroomReservationRepository clrRepository;

    public DatabaseFiller(StudentRepository studentRepository, PasswordEncoder encoder, ProfessorRepository professorRepository, ClassroomRepository classroomRepository, ClassroomReservationRepository clrRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.classroomRepository = classroomRepository;
        this.encoder = encoder;
        this.clrRepository = clrRepository;
    }

    @Override
    public void afterPropertiesSet() {
        saveClassrooms();
        saveClassroomsReservations();
    }

    /*
    CLASSROOMS
        int class_num;
        int surface;
     */
    public void saveClassrooms(){
        Classroom cl = new Classroom();
        cl.setClass_num(1);
        cl.setSurface(20);
        classroomRepository.save( cl );
    }

    public void saveClassroomsReservations() {
        ClassroomReservation clr = new ClassroomReservation();
        clr.setRoom_num("101");
        clr.setStart_time(830);
        clr.setEnd_time(1030);
        clrRepository.save( clr );
    }
}
