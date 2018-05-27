package cinema.dao.interfaces;

import cinema.domain.User;

import java.util.List;

public interface IUserDao {

    User findByLogin(String login);
    void insert(User user);
    void delete(User user);
    List<User> getUsers();
}
