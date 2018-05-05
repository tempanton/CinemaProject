package cinema.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="c_seance", schema = "public", catalog = "CinemaDatabase")
public class Seance {

    private Long id;
    private Movie movie;
    private Date date;
    private Room room;
    private Double totalPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    //TODO: calculate total price
    @Column(name="totalprice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seance)) return false;
        Seance seance = (Seance) o;
        return Objects.equals(movie, seance.movie) &&
                Objects.equals(date, seance.date) &&
                Objects.equals(room, seance.room) &&
                Objects.equals(totalPrice, seance.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, date, room, totalPrice);
    }

    @Override
    public String toString() {
        return "Seance{" +
                "movie=" + movie +
                ", date=" + date +
                ", room=" + room +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
