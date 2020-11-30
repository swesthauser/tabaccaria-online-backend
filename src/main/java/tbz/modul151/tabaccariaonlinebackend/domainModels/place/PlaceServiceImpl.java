package tbz.modul151.tabaccariaonlinebackend.domainModels.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService{

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    private Place findAllThrow (Optional<Place> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Place> getAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place updateById(String zip, String city, Place objToUpdate) {
        Place oldplace = findAllThrow(placeRepository.findByZipAndCity(zip, city));
        oldplace.setZip(objToUpdate.getZip());
        oldplace.setCity(objToUpdate.getCity());
        placeRepository.save(objToUpdate);
        return objToUpdate;
    }

    @Override
    public Place create(Place object) {
        return placeRepository.save(object);
    }

    @Override
    public Place delete(String zip, String city) {
        placeRepository.deleteById(new PlaceId(zip, city));
        return null;
    }

    @Override
    public Place findByZipAndCity(String zip, String city) {
        return findAllThrow(placeRepository.findByZipAndCity(zip, city));
    }

    @Override
    public Place findById(String zip, String city) {
        return findAllThrow(placeRepository.findById(new PlaceId(zip, city)));
    }
}
