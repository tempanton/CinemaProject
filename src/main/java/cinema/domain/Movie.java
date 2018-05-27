package cinema.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "c_movie", schema = "public", catalog = "CinemaDatabase")
public class Movie {

    private Long id;
    private String title;
    private String duration;
    private Double price;

    private List<Seance> seances;

    @OneToMany(mappedBy = "movie")
    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Column(name="price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(duration, movie.duration) &&
                Objects.equals(price, movie.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, price);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                '}';
    }
}
