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
        saveUsers();
        saveClassrooms();
        saveClassroomsReservations();
    }

    public void saveUsers(){
        Student st = new Student();
        st.setUsername("Johnn");
        st.setPassword( encoder.encode("pass")) ;
        st.setFirstname("John");
        st.setLastname("Doe");
        st.setBirthdate("11201992");
        studentRepository.save( st );

        st = new Student();
        st.setUsername("Jerome");
        st.setPassword( encoder.encode("pass")) ;
        st.setFirstname("Jérôme");
        st.setLastname("Widart");
        st.setBirthdate("11201992");
        studentRepository.save( st );

        st = new Student();
        st.setUsername("Dylan");
        st.setPassword( encoder.encode("pass")) ;
        st.setFirstname("Dylan");
        st.setLastname("Haas");
        st.setBirthdate("11201992");
        studentRepository.save( st );

        st = new Student();
        st.setUsername("Samirah");
        st.setPassword( encoder.encode("pass")) ;
        st.setFirstname("Samirah");
        st.setLastname("Masimina");
        st.setBirthdate("11201992");
        studentRepository.save( st );

        st = new Student();
        st.setUsername("Pacifique");
        st.setPassword( encoder.encode("pass")) ;
        st.setFirstname("Pacifique");
        st.setLastname("NGabo");
        st.setBirthdate("11201992");
        studentRepository.save( st );

        Professor p = new Professor();
        p.setUsername("professor01");
        p.setPassword( encoder.encode("pass")) ;
        p.setFirstname("Alex");
        p.setLastname("Kimts");
        p.setBirthdate("11201992");
        professorRepository.save( p );

        p = new Professor();
        p.setUsername("professor02");
        p.setPassword( encoder.encode("pass")) ;
        p.setFirstname("Severus");
        p.setLastname("Rogue");
        p.setBirthdate("11201992");
        professorRepository.save( p );

        p = new Professor();
        p.setUsername("professor03");
        p.setPassword( encoder.encode("pass")) ;
        p.setFirstname("Dolores");
        p.setLastname("Omb");
        p.setBirthdate("11201992");
        professorRepository.save( p );
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
