package tbz.modul151.tabaccariaonlinebackend.domainModels.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_CATEGORY')")
    public @ResponseBody
    ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_CATEGORY')")
    public @ResponseBody
    ResponseEntity<Category> getById(@PathVariable String id){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_CATEGORY')")
    public @ResponseBody
    ResponseEntity<Category> create(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createNewCategory(category), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_CATEGORY')")
    public @ResponseBody
    ResponseEntity<Category> update(@RequestBody Category category, @PathVariable String id){
        return new ResponseEntity<Category>(categoryService.updateCategory(category, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
    public @ResponseBody
    ResponseEntity<Category> delete(@PathVariable String id){
        return new ResponseEntity<Category>(categoryService.deleteCategory(id), HttpStatus.NO_CONTENT);
    }
}
