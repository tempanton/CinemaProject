package cinema.dao.interfaces;

import cinema.domain.Seance;
import cinema.domain.Ticket;

import java.util.List;

public interface ITicketDao {

    List<Ticket> getTickets();
    List<Ticket> getFreeTickets(Seance seance);
    List<Ticket> getReseredTickets(Seance seance);
    void addTicket(Ticket ticket);
}
