package cinema.dao;

import cinema.domain.User;

public interface IUserDao {

    User findByLogin(String login);
    void insert(User user);
    void delete(User user);

}
