package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import tbz.modul151.tabaccariaonlinebackend.domainModels.order.Order;

import java.util.List;

public interface OrderDetailsService {

    public List<OrderDetails> getAllOrderDetails();
    public OrderDetails getOrderDetailsById(String id);
    public OrderDetails createNewOrderDetails(OrderDetails orderDetails);
    public OrderDetails updateOrderDetails (OrderDetails orderDetails, String id);
    public OrderDetails deleteOrderDetails(String id);
    public void addDetailsToOrder(OrderDetails orderDetails);
    public List<OrderDetails> getAllByOrder(String id);
    public List<String> funcCountAndGroupAllByArticle();
    public Integer procedureCountAllByArticleId(String articleId);
}
