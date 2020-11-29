package tbz.modul151.tabaccariaonlinebackend.domainModels.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_ADDRESS')")
    public @ResponseBody
    ResponseEntity<List<Address>> getAll(){
        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ADDRESS')")
    public @ResponseBody
    ResponseEntity<Address> getById(@PathVariable String id){
        return new ResponseEntity<>(addressService.getById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_ADDRESS')")
    public @ResponseBody
    ResponseEntity<Address> create(@RequestBody Address objectToUpdate) {
        return new ResponseEntity<>(addressService.create(objectToUpdate), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ADDRESS')")
    public @ResponseBody
    ResponseEntity<Address> update(@RequestBody Address objectToUpdate, @PathVariable String id){
        return new ResponseEntity<>(addressService.updateById(id, objectToUpdate), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ADDRESS')")
    public @ResponseBody
    ResponseEntity<Address> delete(@PathVariable String id){
        return new ResponseEntity<>(addressService.delete(id), HttpStatus.NO_CONTENT);
    }
}
