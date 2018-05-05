package cinema.dao;

import cinema.domain.User;
import cinema.utils.HibernateService;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{

    public User findByLogin(String login) {
        return (User) HibernateService.getSession().createQuery("FROM User WHERE login=:param")
                .setParameter("param", login)
                .uniqueResult();
    }


    public void insert(User user) {
        HibernateService.getSession().saveOrUpdate(user);
    }

    public void delete(User user) {
        HibernateService.getSession().delete(user);
    }
}
