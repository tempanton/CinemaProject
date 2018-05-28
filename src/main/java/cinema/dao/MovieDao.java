package cinema.dao;

import cinema.dao.interfaces.IMovieDao;
import cinema.domain.Movie;
import cinema.utils.HibernateService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MovieDao implements IMovieDao {
    @Override
    public void addMovie(Movie movie) {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(movie);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Movie> getMovies() {
        Session session = HibernateService.getSessionFactory().openSession();
        List movies = session.createQuery("FROM Movie").list();
        session.close();
        return movies;

    }

    @Override
    @SuppressWarnings("unchecked")
    public Movie getMovieById(Long id) {
        Session session = HibernateService.getSessionFactory().openSession();
        Movie movie = (Movie) session.createQuery("FROM Movie WHERE id=:param")
                .setParameter("param",id)
                .uniqueResult();
        session.close();
        return movie;
    }


}
