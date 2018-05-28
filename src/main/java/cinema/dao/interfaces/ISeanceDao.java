package cinema.dao.interfaces;

import cinema.domain.Seance;

import java.util.List;

public interface ISeanceDao {

    Seance findByTitle(String title);
    Seance findById(Long id);
    List<Seance> getSeances();
    void addSeance(Seance seance);
    List<Seance> getSeancesByMovieId(Long id);

}
