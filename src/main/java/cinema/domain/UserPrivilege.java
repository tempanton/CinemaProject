package cinema.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="c_user_privileges", schema = "public", catalog = "CinemaDatabase")
public class UserPrivilege {

    private Long id;
    private String name;
    private Collection<Role> roles;

    public UserPrivilege() {
        super();
    }

    public UserPrivilege(final String name) {
        super();
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userPrivileges")
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPrivilege)) return false;
        UserPrivilege userPrivilege = (UserPrivilege) o;
        return Objects.equals(id, userPrivilege.id) &&
                Objects.equals(name, userPrivilege.name) &&
                Objects.equals(roles, userPrivilege.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roles);
    }

    @Override
    public String toString() {
        return "UserPrivilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}