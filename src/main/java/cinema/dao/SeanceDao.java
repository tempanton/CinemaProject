package cinema.dao;

import cinema.dao.interfaces.ISeanceDao;
import cinema.domain.Seance;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeanceDao implements ISeanceDao {
    @Override
    public Seance findByTitle(String title) {
        Session session = HibernateService.getSessionFactory().openSession();
        Seance seance = (Seance) session.createQuery("FROM Seance WHERE movie.title =:param")
                .setParameter("param",title)
                .uniqueResult();
        session.close();
        return seance;
    }

    @Override
    public Seance findById(Long id) {
        Session session = HibernateService.getSessionFactory().openSession();
        Seance seance = (Seance) session.createQuery("FROM Seance WHERE id =:param")
                .setParameter("param",id)
                .uniqueResult();
        session.close();
        return seance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Seance> getSeances() {
        Session session = HibernateService.getSessionFactory().openSession();
        List<Seance> seances = session.createQuery("FROM Seance")
                .list();
        session.close();
        return seances;
    }

    @Override
    public void addSeance(Seance seance) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(seance);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Seance> getSeancesByMovieId(Long id) {
        Session session = HibernateService.getSessionFactory().openSession();
        List<Seance> seances = session.createQuery("FROM Seance WHERE movie.id =:param")
                .setParameter("param",id)
                .list();
        session.close();
        return seances;
    }
}
