package cinema.dao;

import cinema.dao.interfaces.IRoleDao;
import cinema.domain.Role;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDao implements IRoleDao {
    @Override
    public Role findByName(String name) {
        Session session = HibernateService.getSessionFactory().openSession();
        Role role = (Role) session.createQuery("FROM Role WHERE name=:param")
                .setParameter("param", name)
                .uniqueResult();
        session.close();
        return role;
    }

    public void insert(Role role) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(role);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Role role) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(role);
        session.getTransaction().commit();
        session.close();
    }


}
