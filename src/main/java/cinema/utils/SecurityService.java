package cinema.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityService implements ISecurityService {

    @Autowired
    private CUserDetailsService cUserDetailsService;

    @Override
    @Transactional(readOnly = true)
    public String findLoggedLogin() {
        return ((UserDetails)
                SecurityContextHolder
                        .getContext().getAuthentication().getDetails())
                .getUsername();
    }

    @Override
    public void autoLogin(String login, String password) {
        UserDetails userDetails = cUserDetailsService.loadUserByUsername(login);
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        if (authToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

    /**TODO:
     * authentication manager factory
     * handler
     */

}