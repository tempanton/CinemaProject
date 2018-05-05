package cinema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="c_room", schema = "public", catalog = "CinemaDatabase")
public class Room {

    private Long id;
    private String room;
    private int seat;
    private String privilege;
    private Double coeff;
    private boolean reserved;

    @Id
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

    @Column(name="seat")
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Column(name="privilege")
    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Column(name="coefficient")
    public Double getCoeff() { return coeff; }

    public void setCoeff(Double coeff) {
        this.coeff = coeff;
    }

    @Column(name="reservation_flag")
    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room1 = (Room) o;

        if (seat != room1.seat) return false;
        if (id != null ? !id.equals(room1.id) : room1.id != null) return false;
        if (room != null ? !room.equals(room1.room) : room1.room != null) return false;
        if (privilege != null ? !privilege.equals(room1.privilege) : room1.privilege != null) return false;
        return coeff != null ? coeff.equals(room1.coeff) : room1.coeff == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + seat;
        result = 31 * result + (privilege != null ? privilege.hashCode() : 0);
        result = 31 * result + (coeff != null ? coeff.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", seat=" + seat +
                ", privilege='" + privilege + '\'' +
                ", coeff=" + coeff +
                '}';
    }
}
