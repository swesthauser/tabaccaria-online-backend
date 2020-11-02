package tbz.modul151.tabaccariaonlinebackend.domainModels.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_PAYMENT')")
    public @ResponseBody
    ResponseEntity<List<Payment>> getAll(){
        return new ResponseEntity<List<Payment>>(paymentService.getAllPayments(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_PAYMENT')")
    public @ResponseBody
    ResponseEntity<Payment> getById(@PathVariable String id){
        return new ResponseEntity<Payment>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_PAYMENT')")
    public @ResponseBody
    ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return new ResponseEntity<Payment>(paymentService.createNewPayment(payment), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PAYMENT')")
    public @ResponseBody
    ResponseEntity<Payment> update(@RequestBody Payment payment, @PathVariable String id){
        return new ResponseEntity<Payment>(paymentService.updatePayment(payment, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_PAYMENT')")
    public @ResponseBody
    ResponseEntity<Payment> delete(@PathVariable String id){
        return new ResponseEntity<Payment>(paymentService.deletePayment(id), HttpStatus.NO_CONTENT);
    }
}
