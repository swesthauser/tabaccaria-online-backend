package tbz.modul151.tabaccariaonlinebackend.domainModels.place;

import java.util.List;

public interface PlaceService {

    public List<Place> getAll();
    public Place updateById(String zip, String city, Place objToUpdate);
    public Place create (Place object);
    public Place delete (String zip, String city);
    public Place findByZipAndCity(String zip, String city);
    public Place findById(String zip, String city);
}
