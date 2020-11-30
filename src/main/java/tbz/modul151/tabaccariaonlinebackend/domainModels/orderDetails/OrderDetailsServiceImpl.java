package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbz.modul151.tabaccariaonlinebackend.domainModels.order.Order;
import tbz.modul151.tabaccariaonlinebackend.domainModels.order.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    private OrderDetailsRepository orderDetailsRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, OrderRepository orderRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderRepository = orderRepository;
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
        orderDetails = orderDetailsRepository.save(orderDetails);
        this.addDetailsToOrder(orderDetails);
        /*
        Optional<Order> order = orderRepository.findById(orderDetails.getOrder().getId());
        order.get().getOrderDetailsList().add(orderDetails);
        order.get().setId(orderDetails.getOrder().getId());
        orderRepository.save(order.get());

         */
        return orderDetails;
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails, String id) {
        findAllThrow(orderDetailsRepository.findById(id));
        orderDetails.setId(id);
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails deleteOrderDetails(String id) {
        OrderDetails orderDetails = this.getOrderDetailsById(id);
        Optional<Order> order = orderRepository.findById(orderDetails.getOrder().getId());
        order.get().getOrderDetailsList().remove(orderDetails);
        order.get().setId(orderDetails.getOrder().getId());
        orderRepository.save(order.get());
        orderDetailsRepository.deleteById(id);
        return null;
    }

    @Override
    public void addDetailsToOrder(OrderDetails orderDetails) {
        Optional<Order> order = orderRepository.findById(orderDetails.getOrder().getId());
        order.get().getOrderDetailsList().add(orderDetails);
        order.get().setId(orderDetails.getOrder().getId());
        orderRepository.save(order.get());
    }

    @Override
    public List<OrderDetails> getAllByOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);
        return orderDetailsRepository.getAllByOrder(order.get());
    }

    @Override
    public List<String> funcCountAndGroupAllByArticle() {
        return orderDetailsRepository.funcCountAndGroupAllByArticle();
    }

    @Override
    public Integer procedureCountAllByArticleId(String articleId) {
        return orderDetailsRepository.countAllByArticleId(articleId);
    }

}
