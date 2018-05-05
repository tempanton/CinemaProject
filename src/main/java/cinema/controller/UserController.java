package cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cinema.domain.User;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @RequestMapping(value="/welcome",method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @ResponseBody
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    @ResponseBody
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }


    /** TODO:
     * validation
     * redirect
     * */
}
