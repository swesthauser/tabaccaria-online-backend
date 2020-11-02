package tbz.modul151.tabaccariaonlinebackend.domainModels.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return null;
    }

    @Override
    public Payment getPaymentById(String id) {
        return null;
    }

    @Override
    public Payment createNewPayment(Payment payment) {
        return null;
    }

    @Override
    public Payment updatePayment(Payment payment, String id) {
        return null;
    }

    @Override
    public Payment deletePayment(String id) {
        return null;
    }
}
