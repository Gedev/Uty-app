package technobel.gedev.utyapp.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrative")
@Getter @Setter
public class Administrative extends User {

    @Column
    private Integer hire_date;
}
