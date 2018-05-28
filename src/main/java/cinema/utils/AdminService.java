package cinema.utils;

import cinema.dao.MovieDao;
import cinema.dao.RoomDao;
import cinema.dao.SeanceDao;
import cinema.dao.UserDao;
import cinema.domain.*;
import cinema.utils.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SeanceDao seanceDao;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    @Transactional
    public void createSeance(Date date, Movie movie, Room room) {
        Seance seance = new Seance();
        seance.setDate(date);
        seance.setMovie(movie);
        seance.setRoom(room);
        seanceDao.addSeance(seance);
    }

    //TODO: duration to time
    @Override
    @Transactional
    public void createMovie(String title, Double price, String duration) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setPrice(price);
        movie.setDuration(duration);
        movieDao.addMovie(movie);
    }

    @Override
    @Transactional
    public void createRoom(String roomTitle, Set<Seat> seats) {
        Room room = new Room();
        room.setRoom(roomTitle);
        room.setSeats(seats);
        roomDao.addRoom(room);
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return userDao.getUsers();
    }

}
