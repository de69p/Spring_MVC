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
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    int id;

    @Enumerated(EnumType.STRING)
    RoleName roleName;
}
