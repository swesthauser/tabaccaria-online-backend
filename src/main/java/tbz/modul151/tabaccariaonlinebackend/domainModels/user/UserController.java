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

    //PUT add to the favorit list
    @PutMapping("/{userId}/addFavorite/{articleId}")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public @ResponseBody
    ResponseEntity<User> addArticleToFav(@RequestBody User user, @PathVariable String userId, @PathVariable String articleId){
        return new ResponseEntity<User>(userService.addArticleToFavorites(userId, articleId, user), HttpStatus.OK);
    }

    //PUT remove from favorites
    @PutMapping("/{id}/removeArticle/{articleId}")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public @ResponseBody
    ResponseEntity<User> removeArticleFromFav(@RequestBody User user, @PathVariable String id, @PathVariable String articleId){
        return new ResponseEntity<User>(userService.removeArticleFromFavorites(id, articleId, user), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_USER')")
    public @ResponseBody
    ResponseEntity<User> delete(@PathVariable String id){
        return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
