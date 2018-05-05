package cinema.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="c_role", schema = "public", catalog = "CinemaDatabase")
public class Role {

    private Long id;
    private String name;

    private Collection<User> users;
    private Collection<UserPrivilege> userPrivileges;

    public Role() {
        super();
    }

    public Role(String name) {
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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @ManyToMany
    @JoinTable(
            name = "c_user_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "privilege_id"))
    public Collection<UserPrivilege> getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(Collection<UserPrivilege> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(users, role.users) &&
                Objects.equals(userPrivileges, role.userPrivileges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, userPrivileges);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", userPrivileges=" + userPrivileges +
                '}';
    }
}
