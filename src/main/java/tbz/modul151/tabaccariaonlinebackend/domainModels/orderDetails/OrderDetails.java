package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import tbz.modul151.tabaccariaonlinebackend.domainModels.article.Article;
import tbz.modul151.tabaccariaonlinebackend.domainModels.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "quantity")
    private int quantity;

    //@JsonBackReference(value="orderdetails-article")
    //@ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private String articleId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetails(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    /*
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }



    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

     */

}
