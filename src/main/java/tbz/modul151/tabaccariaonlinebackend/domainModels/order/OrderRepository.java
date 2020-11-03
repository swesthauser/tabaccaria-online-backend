package tbz.modul151.tabaccariaonlinebackend.domainModels.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    Order findByOrderDateIsNullAndUserId(String id);
}
