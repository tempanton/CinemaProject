package cinema.utils.interfaces;

import cinema.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAdminService {
    void createSeance(Date date, Movie movie, Room room);
    void createMovie(String title, Double price, String duration);
    void createRoom(String roomTitle, Set<Seat> seats);
    List<User> getUsersList();
}
