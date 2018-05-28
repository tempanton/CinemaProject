package cinema.dao;

import cinema.dao.interfaces.IUserDao;
import cinema.domain.User;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao implements IUserDao {

    @Override
    public User findByLogin(String login) {
        Session session = HibernateService.getSessionFactory().openSession();
        User user = (User) session.createQuery("FROM User WHERE login=:param")
                .setParameter("param", login)
                .uniqueResult();
        session.close();

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Session session = HibernateService.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("FROM User")
                .list();
        session.close();
        return users;
    }

    public void insert(User user) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
