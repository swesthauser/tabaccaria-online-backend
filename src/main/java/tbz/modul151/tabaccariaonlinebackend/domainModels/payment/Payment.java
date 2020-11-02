package tbz.modul151.tabaccariaonlinebackend.domainModels.payment;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import tbz.modul151.tabaccariaonlinebackend.domainModels.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "is_allowed")
    private Boolean isAllowed;

    @OneToMany(mappedBy="payment")
    private Set<Order> orders;

    public Payment (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean getAllowed() {
        return isAllowed;
    }

    public void setAllowed(Boolean allowed) {
        isAllowed = allowed;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
