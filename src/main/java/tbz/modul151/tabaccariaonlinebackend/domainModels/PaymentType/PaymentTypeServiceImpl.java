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

    @Override
    public List<PaymentType> getAll() {
        return null;
    }

    @Override
    public PaymentType getById(String id) {
        return null;
    }

    @Override
    public PaymentType updateById(String id, PaymentType objToUpdate) {
        return null;
    }

    @Override
    public PaymentType create(PaymentType object) {
        return null;
    }

    @Override
    public PaymentType delete(String id) {
        return null;
    }
}
