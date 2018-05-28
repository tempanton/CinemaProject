package cinema.controller;

import cinema.dao.MovieDao;
import cinema.dao.RoomDao;
import cinema.dao.SeanceDao;
import cinema.domain.Movie;
import cinema.domain.Room;
import cinema.domain.Seance;
import cinema.utils.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class  AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private SeanceDao seanceDao;
    @Autowired
    private MovieDao movieDao;


//TODO:

    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {

        model.addAttribute("newRoom",new Room());
        model.addAttribute("newSeance", new Seance());
        model.addAttribute("newMovie", new Movie());
        return "admin";
    }

    //Show seance form
    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin/addSeance", method = RequestMethod.GET)
    public String seance(Model model) {
        model.addAttribute("seances", seanceDao.getSeances());
        return "";
    }

    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin/addSeance", method = RequestMethod.POST)
    public String seance(@RequestParam("date") Date date,
                         @RequestParam("movie") Movie movie,
                         @RequestParam("room") Room room) {
        adminService.createSeance(date,movie,room);
        return "";
    }

    //Show movie form
    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin/addMovie", method = RequestMethod.GET)
    public String movie(@ModelAttribute("Title") String title,
                        @ModelAttribute("Duration") String duration,
                        @ModelAttribute("Price") String price,
                        Model model) {
        adminService.createMovie(title,Double.parseDouble(price),duration);
        model.addAttribute("movies", movieDao.getMovies());
        return "admin/addMovie";
    }

    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin/addMovie", method = RequestMethod.POST)
    public String movie(@ModelAttribute("Title") String title,
                         @ModelAttribute("Duration") String duration,
                         @ModelAttribute("Price") String price) {
        System.out.println("HEY");
        adminService.createMovie(title,Double.parseDouble(price),duration);
        return "redirect:/admin";
    }

    //Show room form
    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin/addRoom", method = RequestMethod.GET)
    public String room(Model model) {
        model.addAttribute("rooms",roomDao.getRooms());
        return "";
    }

    @RequestMapping(value = "/admin/addRoom", method = RequestMethod.POST)
    public String room(@RequestParam("Title") String title,
                       @RequestParam("Price") Double price,
                       @RequestParam("Duration") String duration) {
        adminService.createMovie(title,price,duration);
        return "";
    }

    //Show statistics
    @Secured({"ADMIN"})
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String statistic(Model model) {
        model.addAttribute("users", adminService.getUsersList());
        return "";
    }

}
