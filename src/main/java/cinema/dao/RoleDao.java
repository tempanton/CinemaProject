package cinema.dao;

import cinema.domain.Role;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao implements IRoleDao{

    public Role findById(Long id) {
        Session session = HibernateService.getSessionFactory().openSession();
        Role role = (Role) HibernateService.getSession().createQuery("FROM Role WHERE id=:param")
                .setParameter("param", id)
                .uniqueResult();
        session.close();
        return role;
    }
}
