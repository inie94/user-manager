package ru.inie.edu.storages.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.action.internal.UnresolvedEntityInsertActions;
import ru.inie.edu.services.models.User;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname", length = 255, nullable = false)
    private String firstName;
    @Column(name = "lastName", length = 255, nullable = false)
    private String lastName;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "birthDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public UserEntity fill(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthDate = new Date(user.getBirthDate().getTime());
        return this;
    }

}
