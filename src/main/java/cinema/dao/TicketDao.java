package cinema.dao;

import cinema.domain.Ticket;
import cinema.utils.HibernateService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao implements ITicketDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> getTickets() {
        return HibernateService.getSession().createQuery("FROM Ticket").list();
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> getFreeTickets() {
        return (List) HibernateService.getSession().createQuery("" +
                "FROM Ticket, Seance, Room " +
                "WHERE room.reserved =: param " +
                "AND Ticket.seance = Seance " +
                "AND Seance.room = Room")
                .setParameter("param",false).list();

    }
}
