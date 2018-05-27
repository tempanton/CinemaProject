package cinema.dao.interfaces;

import cinema.domain.Role;

public interface IRoleDao {

    Role findByName(String name);
    void insert(Role role);
    void delete(Role role);
}
