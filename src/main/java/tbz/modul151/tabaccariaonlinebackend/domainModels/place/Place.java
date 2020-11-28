package tbz.modul151.tabaccariaonlinebackend.domainModels.place;

import javax.persistence.*;

@Entity
@IdClass(PlaceId.class)
@Table(name = "place")
public class Place {

    @Id
    private String zip;
    @Id
    private String city;

    public Place(String zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
