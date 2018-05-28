package cinema.dao.interfaces;

import cinema.domain.Movie;

import java.util.List;

public interface IMovieDao {

    void addMovie(Movie movie);
    List<Movie> getMovies();
    Movie getMovieById(Long id);
}
