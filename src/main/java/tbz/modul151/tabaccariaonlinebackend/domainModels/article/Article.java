package tbz.modul151.tabaccariaonlinebackend.domainModels.article;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import tbz.modul151.tabaccariaonlinebackend.domainModels.category.Category;
import tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails.OrderDetails;
import tbz.modul151.tabaccariaonlinebackend.domainModels.user.User;

import javax.persistence.*;
import javax.xml.catalog.CatalogException;
import java.util.Set;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "article_name")
    private String articleName;

    @Column(name = "article_description")
    private String articleDescription;

    @Column(name = "brand")
    private String brand;

    @Column(name = "is_available")
    private Boolean available;

    @Column(name = "available_colors")
    private String availableColors;

    @Column(name = "available_size")
    private String availableSize;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
    private Set<OrderDetails> orderDetailsSet;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    //category

    public Article (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(String availableColors) {
        this.availableColors = availableColors;
    }

    public String getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(String availableSize) {
        this.availableSize = availableSize;
    }

    public Set<OrderDetails> getOrderDetailsSet() {
        return orderDetailsSet;
    }

    public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
        this.orderDetailsSet = orderDetailsSet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
