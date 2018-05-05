package cinema.dao;

import cinema.domain.Role;
import cinema.utils.HibernateService;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao implements IRoleDao{

    public Role findById(Long id) {
        return (Role) HibernateService.getSession().createQuery("FROM Role WHERE id=:param")
                .setParameter("param", id)
                .uniqueResult();
    }
}
