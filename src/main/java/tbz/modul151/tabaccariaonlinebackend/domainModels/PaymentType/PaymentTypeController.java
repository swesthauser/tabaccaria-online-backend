package tbz.modul151.tabaccariaonlinebackend.domainModels.PaymentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymenttypes")
public class PaymentTypeController {

    private PaymentTypeService paymentTypeService;

    @Autowired
    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_PAYMENT_TYPE')")
    public @ResponseBody
    ResponseEntity<List<PaymentType>> getAll(){
        return new ResponseEntity<>(paymentTypeService.getAll(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_PAYMENT_TYPE')")
    public @ResponseBody
    ResponseEntity<PaymentType> getById(@PathVariable String id){
        return new ResponseEntity<>(paymentTypeService.getById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_PAYMENT_TYPE')")
    public @ResponseBody
    ResponseEntity<PaymentType> create(@RequestBody PaymentType objectToUpdate) {
        return new ResponseEntity<>(paymentTypeService.create(objectToUpdate), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PAYMENT_TYPE')")
    public @ResponseBody
    ResponseEntity<PaymentType> update(@RequestBody PaymentType objectToUpdate, @PathVariable String id){
        return new ResponseEntity<>(paymentTypeService.updateById(id, objectToUpdate), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_PAYMENT_TYPE')")
    public @ResponseBody
    ResponseEntity<PaymentType> delete(@PathVariable String id){
        return new ResponseEntity<>(paymentTypeService.delete(id), HttpStatus.NO_CONTENT);
    }
}
