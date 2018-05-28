package cinema.utils;

import cinema.utils.interfaces.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SecurityService implements ISecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

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

        authenticationManager.authenticate(authToken);
        if (authToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

}