package tbz.modul151.tabaccariaonlinebackend.domainModels.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_ROLE')")
    public @ResponseBody
    ResponseEntity<List<Role>> getAll(){
        return new ResponseEntity<List<Role>>(roleService.getAllRoles(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ROLE')")
    public @ResponseBody
    ResponseEntity<Role> getById(@PathVariable String id){
        return new ResponseEntity<Role>(roleService.getById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    public @ResponseBody
    ResponseEntity<Role> create(@RequestBody Role role) {
        return new ResponseEntity<Role>(roleService.createNewRole(role), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ROLE')")
    public @ResponseBody
    ResponseEntity<Role> update(@RequestBody Role role, @PathVariable String id){
        return new ResponseEntity<Role>(roleService.updateRole(role, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ROLE')")
    public @ResponseBody
    ResponseEntity<Role> delete(@PathVariable String id){
        return new ResponseEntity<Role>(roleService.deleteRole(id), HttpStatus.NO_CONTENT);
    }
}
