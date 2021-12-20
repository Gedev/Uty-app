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

    @Column(unique = true)
    String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Classroom> classrooms;
}
