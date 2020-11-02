package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import java.util.List;

public interface OrderDetailsService {

    public List<OrderDetails> getAllOrderDetails();
    public OrderDetails getOrderDetailsById(String id);
    public OrderDetails createNewOrderDetails(OrderDetails orderDetails);
    public OrderDetails updateOrderDetails (OrderDetails orderDetails, String id);
    public OrderDetails deleteOrderDetails(String id);
}
