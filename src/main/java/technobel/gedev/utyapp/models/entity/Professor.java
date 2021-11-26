package technobel.gedev.utyapp.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
@Getter @Setter
public class Professor extends User {

    @Column
    private Integer hire_date;

    @OneToMany(mappedBy = "professor")
    private List<ClassroomReservation> classroomReservation;

//      @ElementCollection(fetch = FetchType.EAGER)
//      private List<String> professor_sections;
}