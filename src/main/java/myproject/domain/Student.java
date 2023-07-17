package myproject.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "FK_User"),
    inverseJoinColumns = @JoinColumn(name = "FK_Role"))
    List<Role> roles;

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
