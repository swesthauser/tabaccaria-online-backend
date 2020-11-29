package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import tbz.modul151.tabaccariaonlinebackend.domainModels.order.Order;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

    List<OrderDetails> getAllByOrder(Order order);

    @Procedure(procedureName = "COUNT_ALL_ORDERS_DETAILS_BY_ARTICLE_ID")
    int countAllByArticleId(String articleId);

    @Procedure(procedureName = "COUNT_ALL_BY_ARTICLE_ID_AND_USER_ID")
    int countAllByArticleIdAndOrder_UserId(String articleId, String userId);

    /*
    @Query(value = "SELECT COUNT(public.order_details.article_id) as amount, public.article.article_name FROM public.order_details \n" +
            "INNER JOIN public.article ON public.order_details.article_id=public.article.id  GROUP BY public.article.article_name\n" +
            "ORDER BY amount ASC", nativeQuery = true)

     */

}
