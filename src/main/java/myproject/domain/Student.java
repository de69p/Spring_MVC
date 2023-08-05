package myproject.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String email;

    String password;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "student")
    List<Phone> phones;

    @ManyToMany
    @JoinTable(name = "student_role", joinColumns = @JoinColumn(name = "FK_student"),
    inverseJoinColumns = @JoinColumn(name = "FK_role"))
    Set<Role> roles;

    private String getPhonesAsString() {
        if (phones != null && !phones.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Phone phone : phones) {
                sb.append(phone.toString());
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        } else {
            return "N/A";
        }
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", phones=" + getPhonesAsString() +
                '}';
    }

}
