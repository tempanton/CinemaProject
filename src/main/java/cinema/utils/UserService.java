package cinema.utils;

import cinema.dao.RoleDao;
import cinema.dao.UserDao;
import cinema.domain.Role;
import cinema.domain.User;
import cinema.utils.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void registerAccount(User user) {
        if(userDao.findByLogin(user.getLogin()) == null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            createRoleIfNotFound("ADMIN");
            createRoleIfNotFound("USER");

            Role userRole = roleDao.findByName("USER");
            user.setRoles(Arrays.asList(userRole));
            userDao.insert(user);
        }
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
