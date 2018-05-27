package cinema.dao;

import cinema.dao.interfaces.ITicketDao;
import cinema.domain.Seance;
import cinema.domain.Ticket;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TicketDao implements ITicketDao {

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Ticket> getTickets() {
        Session session = HibernateService.getSessionFactory().openSession();
        List tickets = session.createQuery("FROM Ticket").list();
        session.close();
        return tickets;
    }

    //TODO:
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Ticket> getFreeTickets(Seance seance) {
        Session session = HibernateService.getSessionFactory().openSession();
        List tickets = session.createQuery("" +
                "FROM Ticket, Seance, Room " +
                "WHERE Ticket.seance =:seance " +
                "AND Seance.room = Room")
                .setParameter("seance",seance).list();
        session.close();
        return tickets;
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Ticket> getReseredTickets(Seance seance) {
        Session session = HibernateService.getSessionFactory().openSession();
        List tickets = session.createQuery("" +
                "FROM Ticket, Seance, Room " +
                "WHERE Ticket.seance =:seance " +
                "AND Seance.room = Room")
                .setParameter("seance",seance).list();
        session.close();
        return tickets;
    }
    @Override
    public void addTicket(Ticket ticket) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ticket);
        session.getTransaction().commit();
        session.close();
    }


}
