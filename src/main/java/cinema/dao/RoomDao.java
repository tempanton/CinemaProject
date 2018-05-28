package cinema.dao;

import cinema.dao.interfaces.IRoomDao;
import cinema.domain.Room;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoomDao implements IRoomDao {
    @Override
    public void addRoom(Room room) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(room);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> getRooms() {
        Session session = HibernateService.getSessionFactory().openSession();
        List<Room> rooms = session.createQuery("FROM Room").list();
        session.close();
        return rooms;
    }
}
