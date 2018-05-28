package cinema.utils;

import cinema.dao.OrderDao;
import cinema.dao.TicketDao;
import cinema.domain.Order;
import cinema.domain.Seance;
import cinema.domain.Ticket;
import cinema.domain.User;
import cinema.utils.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TicketDao ticketDao;

    @Override
    @Transactional
    public void order(User user, Seance seance, int amount) {
        List<Ticket> ordered = new ArrayList<>();
        orderDao.addOrder(new Order(ordered,user));
    }
}
