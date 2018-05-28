package cinema.utils.interfaces;

import cinema.domain.Seance;
import cinema.domain.Ticket;
import cinema.domain.User;

import java.util.List;

public interface IOrderService {

    void order(User user, Seance seance, int amount);

}
