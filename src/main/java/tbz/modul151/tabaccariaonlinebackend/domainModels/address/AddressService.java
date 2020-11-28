package tbz.modul151.tabaccariaonlinebackend.domainModels.address;

import java.util.List;

public interface AddressService {

    public List<Address> getAll();
    public Address getById (String id);
    public Address updateById(String id, Address objToUpdate);
    public Address create (Address object);
    public Address delete (String id);
}
