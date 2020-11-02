package tbz.modul151.tabaccariaonlinebackend.domainModels.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_STOCK')")
    public @ResponseBody
    ResponseEntity<List<Stock>> getAll(){
        return new ResponseEntity<List<Stock>>(stockService.getAllStock(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_STOCK')")
    public @ResponseBody
    ResponseEntity<Stock> getById(@PathVariable String id){
        return new ResponseEntity<Stock>(stockService.getStockById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_STOCK')")
    public @ResponseBody
    ResponseEntity<Stock> create(@RequestBody Stock stock) {
        return new ResponseEntity<Stock>(stockService.createNewStock(stock), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_STOCK')")
    public @ResponseBody
    ResponseEntity<Stock> update(@RequestBody Stock stock, @PathVariable String id){
        return new ResponseEntity<Stock>(stockService.updateStock(stock, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_STOCK')")
    public @ResponseBody
    ResponseEntity<Stock> delete(@PathVariable String id){
        return new ResponseEntity<Stock>(stockService.deleteStock(id), HttpStatus.NO_CONTENT);
    }
}
