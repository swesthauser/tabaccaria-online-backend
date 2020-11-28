package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tbz.modul151.tabaccariaonlinebackend.domainModels.order.Order;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

    List<OrderDetails> getAllByOrder(Order order);
}
