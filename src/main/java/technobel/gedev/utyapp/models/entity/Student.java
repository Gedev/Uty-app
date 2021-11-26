package technobel.gedev.utyapp.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Getter @Setter
public class Student extends User {

}
