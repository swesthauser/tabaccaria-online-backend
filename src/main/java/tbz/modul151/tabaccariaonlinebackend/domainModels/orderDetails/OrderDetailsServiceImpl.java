package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return null;
    }

    @Override
    public OrderDetails getOrderDetailsById(String id) {
        return null;
    }

    @Override
    public OrderDetails createNewOrderDetails(OrderDetails orderDetails) {
        return null;
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails, String id) {
        return null;
    }

    @Override
    public OrderDetails deleteOrderDetails(String id) {
        return null;
    }
}
