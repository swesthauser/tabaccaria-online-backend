package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    private OrderDetails findAllThrow (Optional<OrderDetails> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails getOrderDetailsById(String id) {
        return findAllThrow(orderDetailsRepository.findById(id));
    }

    @Override
    public OrderDetails createNewOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails, String id) {
        findAllThrow(orderDetailsRepository.findById(id));
        orderDetails.setId(id);
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails deleteOrderDetails(String id) {
        orderDetailsRepository.deleteById(id);
        return null;
    }
}
