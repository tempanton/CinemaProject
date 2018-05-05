package cinema.dao;

import cinema.domain.Ticket;

import java.util.List;

public interface ITicketDao {

    List<Ticket> getTickets();
    List getFreeTickets();

}
