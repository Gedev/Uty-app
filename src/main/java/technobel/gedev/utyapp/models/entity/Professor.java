package technobel.gedev.utyapp.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "professor")
@Getter @Setter
public class Professor extends User {

    @Column(nullable = true)
    private LocalDate hire_date;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClassroomReservation> classroomReservation;
}
