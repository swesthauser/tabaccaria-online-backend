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

    @Override
    public List<Place> getAll() {
        return null;
    }

    @Override
    public Place getById(String id) {
        return null;
    }

    @Override
    public Place updateById(String id, Place objToUpdate) {
        return null;
    }

    @Override
    public Place create(Place object) {
        return null;
    }

    @Override
    public Place delete(String id) {
        return null;
    }
}
