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
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> getById(@PathVariable String id){
        return new ResponseEntity<>(placeService.getById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> create(@RequestBody Place objectToUpdate) {
        return new ResponseEntity<>(placeService.create(objectToUpdate), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> update(@RequestBody Place objectToUpdate, @PathVariable String id){
        return new ResponseEntity<>(placeService.updateById(id, objectToUpdate), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_PLACE')")
    public @ResponseBody
    ResponseEntity<Place> delete(@PathVariable String id){
        return new ResponseEntity<>(placeService.delete(id), HttpStatus.NO_CONTENT);
    }
}
