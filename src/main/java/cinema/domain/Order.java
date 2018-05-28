package cinema.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="c_order")
public class Order {

    private Long id;
    private List<Ticket> tickets;
    private User user;

    public Order() {}

    public Order(List<Ticket> tickets, User user) {
        this.tickets = tickets;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
