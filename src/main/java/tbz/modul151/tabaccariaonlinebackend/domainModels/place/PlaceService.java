package tbz.modul151.tabaccariaonlinebackend.domainModels.place;

import java.util.List;

public interface PlaceService {

    public List<Place> getAll();
    public Place getById (String id);
    public Place updateById(String id, Place objToUpdate);
    public Place create (Place object);
    public Place delete (String id);
}
