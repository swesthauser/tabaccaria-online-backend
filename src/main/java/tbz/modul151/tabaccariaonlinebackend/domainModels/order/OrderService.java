package tbz.modul151.tabaccariaonlinebackend.domainModels.order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order getOrderById(String id);
    public Order createNewOrder (Order order);
    public Order updateOrder (Order order, String id);
    public Order deleteOrder(String id);
}
