package cinema.utils;

import cinema.dao.UserDao;
import cinema.domain.Role;
import cinema.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerAccount(User user) {
        User destUser = new User();
        destUser.setLogin(user.getLogin());
        destUser.setPassword(user.getPassword());
        destUser.setBirth(user.getBirth());
        //TODO:
        destUser.setRoles(Arrays.asList(new Role("USER")));
        userDao.insert(destUser);

    }
}
