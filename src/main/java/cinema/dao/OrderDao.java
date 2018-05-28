package cinema.dao;

import cinema.dao.interfaces.IOrderDao;
import cinema.domain.Order;
import cinema.domain.User;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderDao implements IOrderDao {
    @Override
    public void addOrder(Order order) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getOrdersByUser(User user) {
        Session session = HibernateService.getSessionFactory().openSession();
        List<Order> orders = (List<Order>) session.createQuery("FROM Order WHERE user=:param")
                .setParameter("param", user)
                .list();
        session.close();
        return orders;
    }
}
