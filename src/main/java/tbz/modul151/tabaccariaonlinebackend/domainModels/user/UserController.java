package tbz.modul151.tabaccariaonlinebackend.domainModels.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_USER')")
    public @ResponseBody
    ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_USER')")
    public @ResponseBody
    ResponseEntity<User> getById(@PathVariable String id){
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_USER')")
    public @ResponseBody
    ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createNewUser(user), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public @ResponseBody
    ResponseEntity<User> update(@RequestBody User user, @PathVariable String id){
        return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }

    //PUT
    @PutMapping("/{id}/articles/{articleId}")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public @ResponseBody
    ResponseEntity<?> addArticleToFav(@RequestBody User user, @PathVariable String id, @PathVariable String articleId){
        userService.addArticleToFavorites(id, articleId, user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_USER')")
    public @ResponseBody
    ResponseEntity<User> delete(@PathVariable String id){
        return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
