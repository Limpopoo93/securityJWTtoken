package task.company.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "m_users")
public class User extends BaseEntity {

    @Column(name = "user_name")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "m_users_roles",
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_role", referencedColumnName = "id")})
    private List<Role> roles;
}
