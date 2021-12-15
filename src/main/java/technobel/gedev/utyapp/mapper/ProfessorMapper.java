package technobel.gedev.utyapp.mapper;

import org.springframework.stereotype.Service;
import technobel.gedev.utyapp.models.dto.ProfessorDTO;
import technobel.gedev.utyapp.models.entity.Professor;
import technobel.gedev.utyapp.models.entity.Student;
import technobel.gedev.utyapp.models.forms.ProfessorForm;
import technobel.gedev.utyapp.models.forms.StudentForm;

import java.util.stream.Collectors;

@Service
public class ProfessorMapper {

    private final ClassroomReservationMapper clrMapper;

    public ProfessorMapper(ClassroomReservationMapper clrMapper) {
        this.clrMapper = clrMapper;
    }

    public ProfessorDTO toDto(Professor professorEntity) {
        if( professorEntity == null )
            return null;

        return ProfessorDTO.builder()
                .id(professorEntity.getId())
                .username(professorEntity.getUsername())
                .firstname(professorEntity.getFirstname())
                .lastname(professorEntity.getLastname())
                .hire_date(professorEntity.getHire_date())
                .birthdate(professorEntity.getBirthdate())
                .reservations(
                        professorEntity.getClassroomReservation()
                                .stream()
                                .map(clrMapper::toDto)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public Professor formToEntity(ProfessorForm form) {
        if( form == null )
            return null;

        Professor professor = new Professor();
        professor.setUsername(form.getUsername());
        professor.setFirstname(form.getFirstname());
        professor.setLastname(form.getLastname());
        return professor;
    }
}
