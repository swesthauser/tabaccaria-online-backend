package tbz.modul151.tabaccariaonlinebackend.domainModels.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    public List<PaymentType> getAll();
    public PaymentType getById (String id);
    public PaymentType updateById(String id, PaymentType objToUpdate);
    public PaymentType create (PaymentType object);
    public PaymentType delete (String id);
}
