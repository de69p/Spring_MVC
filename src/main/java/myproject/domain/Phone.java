package myproject.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_id")
    int id;

    String number;

    @ManyToOne
    @JoinColumn(name = "FK_phone_student")
    Student student;

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", number='" + number + '\'' +
//                ", student=" + (student != null ? student.getFirstName() + " " + student.getLastName() : "N/A") +
                '}';
    }
}
