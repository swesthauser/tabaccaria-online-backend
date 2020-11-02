package tbz.modul151.tabaccariaonlinebackend.domainModels.stock;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import tbz.modul151.tabaccariaonlinebackend.domainModels.article.Article;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "quantity")
    private int quantity;

    /*
    @ManyToOne
    @JoinColumn(name="stock_id", nullable=false)
    private Stock stock;

    @OneToMany(mappedBy="stock")
    private Set<Article> articles;

     */

    public Stock (){}

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

}
