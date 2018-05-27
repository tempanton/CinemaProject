package cinema.utils;

import cinema.dao.UserDao;
import cinema.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class Validator implements org.springframework.validation.Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (user.getLogin().length() < 8 || user.getLogin().length() > 32) {
            errors.rejectValue("username", "Incorrect login");
        }

        if (user.getLogin().length() < 8 || user.getLogin().length() > 32) {
            errors.rejectValue("login", "Incorrect login length");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Incorrect password length");
        }

    }

}
