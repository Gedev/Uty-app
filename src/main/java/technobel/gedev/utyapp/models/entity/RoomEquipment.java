package technobel.gedev.utyapp.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "room_equipment")
public class RoomEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    boolean has_whiteboard;

    @Column
    boolean has_blackboard;

    @Column
    boolean has_projector;

    @Column
    boolean has_professor_pc;

    @Column
    int students_pc;

    @Column
    boolean has_interactive_whiteboard;

    @Column
    boolean has_speakers;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Classroom> classrooms;
}
