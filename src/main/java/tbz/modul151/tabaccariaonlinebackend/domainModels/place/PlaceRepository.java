package tbz.modul151.tabaccariaonlinebackend.domainModels.place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, PlaceId>{

    Optional<Place> findByZipAndCity(String zip, String city);
}
