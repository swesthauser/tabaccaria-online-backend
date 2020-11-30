package tbz.modul151.tabaccariaonlinebackend.domainModels.place;

import java.io.Serializable;
import java.util.Objects;

public class PlaceId implements Serializable {

    private String zip;

    private String city;

    public PlaceId(){}

    public PlaceId(String zip, String city) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaceId)) return false;
        PlaceId placeId = (PlaceId) o;
        return getZip().equals(placeId.getZip()) &&
                getCity().equals(placeId.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZip(), getCity());
    }
}
