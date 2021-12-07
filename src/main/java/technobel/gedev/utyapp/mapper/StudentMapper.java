package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.StudentDTO;
import technobel.gedev.utyapp.models.entity.Student;
import technobel.gedev.utyapp.models.forms.StudentForm;

@Service
public class StudentMapper {
    public StudentDTO toDto(Student studentEntity) {

        if(studentEntity == null)
            return null;

        return StudentDTO.builder()
                .id(studentEntity.getId())
                .username(studentEntity.getUsername())
                .password(studentEntity.getPassword())
                .firstname(studentEntity.getFirstname())
                .lastname((studentEntity.getLastname()))
                .birthdate(studentEntity.getBirthdate())
                .build();
    }

    public Student formToEntity(StudentForm form) {
        if( form == null )
            return null;

        Student student = new Student();
        student.setUsername(form.getUsername());
        student.setFirstname(form.getFirstname());
        student.setLastname(form.getLastname());
        return student;
    }
}
