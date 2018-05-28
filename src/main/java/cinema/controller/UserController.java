package cinema.controller;

import cinema.dao.UserDao;
import cinema.domain.*;
import cinema.utils.SecurityService;
import cinema.utils.UserService;
import cinema.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/","/registration"}, method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") User user,
                        BindingResult bindingResult) {
        if(userDao.findByLogin(user.getLogin()) == null){
            return "login";
        }
        validator.validate(user, bindingResult);
        if(bindingResult.hasErrors()) {
            return "/login";
        }
        return "redirect:/movies";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User user,
                               BindingResult bindingResult, Model model) {

        validator.validate(user, bindingResult);
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.registerAccount(user);
        securityService.autoLogin(user.getLogin(), user.getPassword());
        return "redirect:/movies";
    }

}
