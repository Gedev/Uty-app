package technobel.gedev.utyapp.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "room_equipment")
public class RoomEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @ManyToMany
    private List<ClassroomReservation> classroomReservations;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Classroom> classrooms;
}
