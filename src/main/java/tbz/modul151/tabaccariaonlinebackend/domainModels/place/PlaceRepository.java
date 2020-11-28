package tbz.modul151.tabaccariaonlinebackend.domainModels.place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, String>{
}
