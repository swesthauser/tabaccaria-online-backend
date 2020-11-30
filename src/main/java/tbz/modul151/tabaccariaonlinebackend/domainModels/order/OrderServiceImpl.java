package tbz.modul151.tabaccariaonlinebackend.domainModels.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails.OrderDetails;

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
    public Order createNewOrder(Order order) {
        return orderRepository.save(order);
        /*
        Optional<Order> optionalOrder = orderRepository.findById(order.getId());
        if (optionalOrder.isPresent()){
            return updateOrder(order, optionalOrder.get().getId());
        } else {
            return orderRepository.save(order);
        }

         */
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
        Order notConfirmedOrder= this.findByOrderDateIsNullAndUserId(userId);
        if (notConfirmedOrder != null){
            return findAllThrow(orderRepository.findById(notConfirmedOrder.getId()));
        } else
         orderRepository.save(new Order(userId, "XLSKDSJTESTCODE"));
        return orderRepository.findByOrderDateIsNullAndUserId(userId);
    }

    @Override
    public Order confirmOrder(Order order, String id) {
        findAllThrow(orderRepository.findById(id));
        if(order.getPayment().getAllowed()){
            order.setOrderDate(LocalDate.now());
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public List<Order> getAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public Order findByOrderDateIsNullAndUserId(String id) {
        return orderRepository.findByOrderDateIsNullAndUserId(id);
    }

    /*
    @Override
    public List<OrderDetails> getAllOrderDetails(String orderId) {
        return null;
    }

     */
}
