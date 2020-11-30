package tbz.modul151.tabaccariaonlinebackend.domainModels.order;

import tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails.OrderDetails;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order getOrderById(String id);
    public Order createNewOrder (Order order);
    public Order updateOrder (Order order, String id);
    public Order deleteOrder(String id);
    public Order getShoppingCartByUserId(String userId);
    public Order confirmOrder(Order order, String id);
    public List<Order> getAllOrdersByUserId(String userId);
    public Order findByOrderDateIsNullAndUserId(String id);
   // public List<OrderDetails> getAllOrderDetails(String orderId);

}
