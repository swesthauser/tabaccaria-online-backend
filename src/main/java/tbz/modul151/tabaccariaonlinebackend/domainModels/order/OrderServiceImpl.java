package tbz.modul151.tabaccariaonlinebackend.domainModels.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private Order findAllThrow (Optional<Order> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        return findAllThrow(orderRepository.findById(id));
    }

    @Override
    public Order createNewOrder(Order order) throws IllegalArgumentException {
        String id = order.getId();
        if (getOrderById(id) == null){
            return orderRepository.save(order);
        } else throw new IllegalArgumentException("Open order already");
    }

    @Override
    public Order updateOrder(Order order, String id) {
        findAllThrow(orderRepository.findById(id));
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    public Order deleteOrder(String id) {
        orderRepository.deleteById(id);
        return null;
    }

    @Override
    public Order getShoppingCartByUserId(String userId) {
        return orderRepository.findByOrderDateIsNullAndUserId(userId);
    }

    @Override
    public Order confirmeOrder(Order order, String id) {
        findAllThrow(orderRepository.findById(id));
        order.setOrderDate(LocalDate.now());
        order.setId(id);
        return orderRepository.save(order);
    }
}
