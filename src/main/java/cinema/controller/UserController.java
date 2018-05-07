package cinema.controller;

import cinema.dao.UserDao;
import cinema.utils.ISecurityService;
import cinema.utils.SecurityService;
import cinema.utils.UserService;
import cinema.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cinema.domain.User;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;
    
    @RequestMapping(value="/welcome",method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "redirect:/welcome";
        }
        securityService.autoLogin(user.getLogin(), user.getPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {

        validator.validate(user, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration";
        }

        userService.registerAccount(user);
        securityService.autoLogin(user.getLogin(), user.getPassword());
        return "redirect:/welcome";
    }

    //TODO: welcome page

}
