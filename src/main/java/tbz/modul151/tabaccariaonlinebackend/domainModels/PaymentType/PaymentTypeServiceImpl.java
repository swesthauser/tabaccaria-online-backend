package tbz.modul151.tabaccariaonlinebackend.domainModels.PaymentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{

    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    private PaymentType findAllThrow (Optional<PaymentType> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<PaymentType> getAll() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getById(String id) {
        return findAllThrow(paymentTypeRepository.findById(id));
    }

    @Override
    public PaymentType updateById(String id, PaymentType objToUpdate) {
        findAllThrow(paymentTypeRepository.findById(id));
        objToUpdate.setId(id);
        return paymentTypeRepository.save(objToUpdate);
    }

    @Override
    public PaymentType create(PaymentType object) {
        return paymentTypeRepository.save(object);
    }

    @Override
    public PaymentType delete(String id) {
        paymentTypeRepository.deleteById(id);
        return null;
    }
}
