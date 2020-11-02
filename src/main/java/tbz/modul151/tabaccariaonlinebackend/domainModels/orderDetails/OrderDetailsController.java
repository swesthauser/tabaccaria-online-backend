package tbz.modul151.tabaccariaonlinebackend.domainModels.orderDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordersdetails")
public class OrderDetailsController {


    private OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_ORDER_DETAILS')")
    public @ResponseBody
    ResponseEntity<List<OrderDetails>> getAll(){
        return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrderDetails(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ORDER_DETAILS')")
    public @ResponseBody
    ResponseEntity<OrderDetails> getById(@PathVariable String id){
        return new ResponseEntity<OrderDetails>(orderDetailsService.getOrderDetailsById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_ORDER_DETAILS')")
    public @ResponseBody
    ResponseEntity<OrderDetails> create(@RequestBody OrderDetails orderDetails) {
        return new ResponseEntity<OrderDetails>(orderDetailsService.createNewOrderDetails(orderDetails), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ORDER_DETAILS')")
    public @ResponseBody
    ResponseEntity<OrderDetails> update(@RequestBody OrderDetails orderDetails, @PathVariable String id){
        return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrderDetails(orderDetails, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ORDER_DETAILS')")
    public @ResponseBody
    ResponseEntity<OrderDetails> delete(@PathVariable String id){
        return new ResponseEntity<OrderDetails>(orderDetailsService.deleteOrderDetails(id), HttpStatus.NO_CONTENT);
    }
}
