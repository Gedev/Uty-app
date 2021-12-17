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

    @Column
    private String room_num;

    @Column
    private LocalDate date;

    @Column
    private LocalTime start_time;

    @Column
    private LocalTime end_time;

    @Column(columnDefinition = "boolean default true")
    private boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoomEquipment> roomEquipments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
