package cinema.utils;

import cinema.dao.RoleDao;
import cinema.dao.UserDao;
import cinema.domain.Role;
import cinema.domain.User;
import cinema.utils.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void registerAccount(User user) {
        User destUser = new User();
        destUser.setLogin(user.getLogin());
        destUser.setPassword(user.getPassword());
        destUser.setBirth(user.getBirth());

        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("USER");

        Role userRole = roleDao.findByName("USER");
        destUser.setRoles(Arrays.asList(userRole));
        userDao.insert(destUser);

    }

    @Transactional
    private Role createRoleIfNotFound(String name) {
        Role role = roleDao.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleDao.insert(role);
        }
        return role;
    }
}
