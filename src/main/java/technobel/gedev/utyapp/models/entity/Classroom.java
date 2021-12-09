package technobel.gedev.utyapp.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classroom")
@Getter @Setter
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String room_num;

    @Column
    private int surface;

    @ManyToMany(mappedBy = "classrooms")
    private Set<RoomEquipment> roomEquipments;


}
