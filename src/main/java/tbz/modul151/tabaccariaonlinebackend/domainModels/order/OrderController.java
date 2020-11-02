package tbz.modul151.tabaccariaonlinebackend.domainModels.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_ORDER')")
    public @ResponseBody
    ResponseEntity<List<Order>> getAll(){
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ORDER')")
    public @ResponseBody
    ResponseEntity<Order> getById(@PathVariable String id){
        return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_ORDER')")
    public @ResponseBody
    ResponseEntity<Order> create(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.createNewOrder(order), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ORDER')")
    public @ResponseBody
    ResponseEntity<Order> update(@RequestBody Order order, @PathVariable String id){
        return new ResponseEntity<Order>(orderService.updateOrder(order, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ORDER')")
    public @ResponseBody
    ResponseEntity<Order> delete(@PathVariable String id){
        return new ResponseEntity<Order>(orderService.deleteOrder(id), HttpStatus.NO_CONTENT);
    }
}
