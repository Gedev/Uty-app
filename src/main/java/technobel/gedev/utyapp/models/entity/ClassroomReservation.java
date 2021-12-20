package technobel.gedev.utyapp.models.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "classroom_reservation")
@Getter @Setter
public class ClassroomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classroom_id", foreignKey = @ForeignKey(name = "FK_classroom_id"))
    private Classroom classroom;

    @Column
    private LocalDate date;

    @Column
    private LocalTime start_time;

    @Column
    private LocalTime end_time;

    @Column (name = "roomType_id")
    private int roomType_id;

    @Column
    private short size;

    @Column(columnDefinition = "boolean default true")
    private boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoomEquipment> roomEquipments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
