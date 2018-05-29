package cinema.utils;

import cinema.dao.UserDao;
import cinema.domain.Role;
import cinema.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class CUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String login) {
        User user = userDao.findByLogin(login);
        Set<GrantedAuthority> authorities = new HashSet();
        for(Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

}
