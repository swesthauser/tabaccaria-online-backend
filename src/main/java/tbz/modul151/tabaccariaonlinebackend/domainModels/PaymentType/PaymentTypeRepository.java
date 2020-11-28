package tbz.modul151.tabaccariaonlinebackend.domainModels.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository  extends JpaRepository<PaymentType, String>{
}
