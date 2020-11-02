package tbz.modul151.tabaccariaonlinebackend.domainModels.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    private Payment findAllThrow (Optional<Payment> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(String id) {
        return findAllThrow(paymentRepository.findById(id));
    }

    @Override
    public Payment createNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment, String id) {
        findAllThrow(paymentRepository.findById(id));
        payment.setId(id);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment deletePayment(String id) {
        paymentRepository.deleteById(id);
        return null;
    }
}
