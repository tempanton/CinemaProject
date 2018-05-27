package cinema.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="c_ticket", schema = "public", catalog = "CinemaDatabase")
public class Ticket {

    private Long id;
    private Seance seance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(seance, ticket.seance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seance);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seance=" + seance +
                '}';
    }
}
