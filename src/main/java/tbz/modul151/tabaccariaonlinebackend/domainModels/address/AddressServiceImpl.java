package tbz.modul151.tabaccariaonlinebackend.domainModels.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    private Address findAllThrow (Optional<Address> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(String id) {
        return findAllThrow(addressRepository.findById(id));
    }

    @Override
    public Address updateById(String id, Address objToUpdate) {
        findAllThrow(addressRepository.findById(id));
        objToUpdate.setStreetNumber(id);
        return addressRepository.save(objToUpdate);
    }

    @Override
    public Address create(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public Address delete(String id) {
        addressRepository.deleteById(id);
        return null;
    }
}
