package tbz.modul151.tabaccariaonlinebackend.domainModels.payment;


import java.util.List;

public interface PaymentService {

    public List<Payment> getAllOrderDetails();
    public Payment getOrderDetailsById(String id);
    public Payment createNewOrderDetails(Payment payment);
    public Payment updateOrderDetails (Payment payment, String id);
    public Payment deleteOrderDetails(String id);
}
