package cinema.domain;

import javax.persistence.*;

@Entity
@Table(name="c_seat")
public class Seat {

    private Long id;
    private int seat;
    private SeatType seatType;
    private boolean reserved;
    private Double coefficient;
    private Room room;

    public Seat() {
    }

    public Seat(Room room) {
        this.room = room;
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "seat")
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "seattype")
    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Column(name = "reservation_flag")
    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Column(name = "coefficient")
    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @ManyToOne
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat1 = (Seat) o;

        if (seat != seat1.seat) return false;
        if (reserved != seat1.reserved) return false;
        if (id != null ? !id.equals(seat1.id) : seat1.id != null) return false;
        if (seatType != seat1.seatType) return false;
        return coefficient != null ? coefficient.equals(seat1.coefficient) : seat1.coefficient == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + seat;
        result = 31 * result + (seatType != null ? seatType.hashCode() : 0);
        result = 31 * result + (reserved ? 1 : 0);
        result = 31 * result + (coefficient != null ? coefficient.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seat=" + seat +
                ", seatType=" + seatType +
                ", reserved=" + reserved +
                ", coefficient=" + coefficient +
                '}';
    }
}
