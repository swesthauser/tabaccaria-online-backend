package tbz.modul151.tabaccariaonlinebackend.domainModels.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_PLACE')")
    public @ResponseBody
    ResponseEntity<List<Place>> getAll(){
        return new ResponseEntity<>(placeService.getAll(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/id/{zip}/{city}")
    @PreAuthorize("hasAuthority('RETRIEVE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> getById(@PathVariable String zip, @PathVariable String city){
        return new ResponseEntity<>(placeService.findById(zip, city), HttpStatus.OK);
    }

    //GET by id findByZipAndCity
    @GetMapping("/{zip}/{city}")
    @PreAuthorize("hasAuthority('RETRIEVE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> getByZipAndCity(@PathVariable String zip, @PathVariable String city){
        return new ResponseEntity<>(placeService.findByZipAndCity(zip, city), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> create(@RequestBody Place objectToUpdate) {
        return new ResponseEntity<>(placeService.create(objectToUpdate), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{zip}/{city}")
    @PreAuthorize("hasAuthority('UPDATE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> update(@RequestBody Place objectToUpdate, @PathVariable String zip, @PathVariable String city){
        return new ResponseEntity<>(placeService.updateById(zip, city, objectToUpdate), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{zip}/{city}")
    @PreAuthorize("hasAuthority('DELETE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> delete(@PathVariable String zip, @PathVariable String city){
        return new ResponseEntity<>(placeService.delete(zip, city), HttpStatus.NO_CONTENT);
    }
}
