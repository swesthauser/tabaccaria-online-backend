package tbz.modul151.tabaccariaonlinebackend.domainModels.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(String id) {
        return null;
    }

    @Override
    public Order createNewOrder(Order article) {
        return null;
    }

    @Override
    public Order updateOrder(Order article, String id) {
        return null;
    }

    @Override
    public Order deleteOrder(String id) {
        return null;
    }
}
