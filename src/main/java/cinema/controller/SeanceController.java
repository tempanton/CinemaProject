package cinema.controller;

import cinema.dao.*;
import cinema.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SeanceController {

    @Autowired
    private SeanceDao seanceDao;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private OrderDao orderDao;

    @Secured({"ADMIN","USER"})
    @RequestMapping(value={"/movies"},method = RequestMethod.GET)
    public String movies(Model model) {
        List<Movie> movies = movieDao.getMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @Secured({"ADMIN","USER"})
    @RequestMapping(value={"/movies"}, method = RequestMethod.POST)
    public String selectMovie(@ModelAttribute("movieBoxForm") Movie movie,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if(bindingResult.hasErrors()) {
            return "redirect:/movies";
        }
        redirectAttributes.addFlashAttribute("movie", movie);

        return "redirect:/movies/" + movie.getId();
    }

    @Secured({"ADMIN","USER"})
    @RequestMapping(value={"/movies/{id}"}, method = RequestMethod.GET)
    public String showMovieForm(@PathVariable("id") Long mid,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        redirectAttributes.addFlashAttribute("seances",seanceDao.getSeancesByMovieId(mid));
        return "redirect:/seances";
    }


    @Secured({"ADMIN","USER"})
    @RequestMapping(value={"/seances"}, method = RequestMethod.GET)
    public String showSeances(@ModelAttribute("seances") List<Seance> seances,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        model.addAttribute("seances", seances);
        return "seances";
    }

    @Secured({"ADMIN","USER"})
    @RequestMapping(value={"/seances/{seanceId}"}, method = RequestMethod.GET)
    public String selectSeance(@PathVariable("seanceId") Long sid,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        redirectAttributes.addFlashAttribute("seanceDetail",seanceDao.findById(sid));
        return "redirect:/seance-detail";
    }

    @Secured({"ADMIN","USER"})
    @RequestMapping(value={"/seance-detail"}, method = RequestMethod.GET)
    public String showSeanceDetails(@ModelAttribute("seanceDetail") Seance seance,
                                    Model model) {
        model.addAttribute("seance", seance);
        return "seance-detail";
    }

/*
    @RequestMapping(value={"/seance-detail"}, method = RequestMethod.POST)
    public String showSeanceDetails(@ModelAttribute("orderForm") Set<Seat> orderedSeats,
                                    @ModelAttribute("seance") Seance seance,
                                    Model model) {
        List<Ticket> tickets = new ArrayList<>();
        orderedSeats.forEach(seat-> {
            seat.setReserved(true);
            Ticket ticket = new Ticket();
            ticket.setSeance(seance);
            ticketDao.addTicket(ticket);
            tickets.add(ticket);
        });
        Order order = new Order(tickets);
        orderDao.addOrder(order);
        return "";
    }
*/
}