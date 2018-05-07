package cinema.dao;

import cinema.domain.User;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{

    public User findByLogin(String login) {
        Session session = HibernateService.getSessionFactory().openSession();
        User user = (User) session.createQuery("FROM User WHERE login=:param")
                .setParameter("param", login)
                .uniqueResult();
        session.close();

        return user;
    }


    public void insert(User user) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(User user) {
        HibernateService.getSession().delete(user);
    }
}
