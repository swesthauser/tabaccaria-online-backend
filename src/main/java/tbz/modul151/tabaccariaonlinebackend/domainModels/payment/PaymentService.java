package tbz.modul151.tabaccariaonlinebackend.domainModels.payment;


import java.util.List;

public interface PaymentService {

    public List<Payment> getAllPayments();
    public Payment getPaymentById(String id);
    public Payment createNewPayment(Payment payment);
    public Payment updatePayment (Payment payment, String id);
    public Payment deletePayment(String id);
}
