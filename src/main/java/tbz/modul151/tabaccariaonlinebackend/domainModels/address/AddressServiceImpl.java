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

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address getById(String id) {
        return null;
    }

    @Override
    public Address updateById(String id, Address objToUpdate) {
        return null;
    }

    @Override
    public Address create(Address object) {
        return null;
    }

    @Override
    public Address delete(String id) {
        return null;
    }
}
