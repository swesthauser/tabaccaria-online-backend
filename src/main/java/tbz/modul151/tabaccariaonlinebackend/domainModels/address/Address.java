package tbz.modul151.tabaccariaonlinebackend.domainModels.address;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "street_number", unique = true, nullable = false)
    private String streetNumber;

    public Address() {
    }

    public Address(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
