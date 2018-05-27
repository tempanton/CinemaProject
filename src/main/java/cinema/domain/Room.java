package cinema.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="c_room", schema = "public", catalog = "CinemaDatabase")
public class Room {

    private Long id;
    private String room;
    private Set<Seat> seats;


    private List<Seance> seance;

    @OneToMany(mappedBy = "room")
    public List<Seance> getSeance() {
        return seance;
    }

    public void setSeance(List<Seance> seance) {
        this.seance = seance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="room")
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @OneToMany(mappedBy = "room")
    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
