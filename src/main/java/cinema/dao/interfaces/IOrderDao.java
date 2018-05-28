package cinema.dao.interfaces;

import cinema.domain.Order;
import cinema.domain.User;

import java.util.List;

public interface IOrderDao {

    void addOrder(Order order);
    List<Order> getOrdersByUser(User user);

}
