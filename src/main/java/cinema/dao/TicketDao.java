package cinema.dao;

import cinema.domain.Ticket;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao implements ITicketDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> getTickets() {
        Session session = HibernateService.getSessionFactory().openSession();
        List tickets = session.createQuery("FROM Ticket").list();
        session.close();
        return tickets;
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> getFreeTickets() {
        Session session = HibernateService.getSessionFactory().openSession();
        List tickets = session.createQuery("" +
                "FROM Ticket, Seance, Room " +
                "WHERE room.reserved =: param " +
                "AND Ticket.seance = Seance " +
                "AND Seance.room = Room")
                .setParameter("param",false).list();
        session.close();
        return tickets;

    }
}
