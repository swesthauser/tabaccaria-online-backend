package tbz.modul151.tabaccariaonlinebackend.domainModels.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private Role findAllThrow (Optional<Role> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }
    @Override
    public List<Role> getAllRoles(){
        return roleRepository.findAll();

    }

    @Override
    public Role getById(String id){
        return findAllThrow(roleRepository.findById(id));
    }

    @Override
    public Role createNewRole (Role role){
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role updateRole (Role role, String id){
        findAllThrow(roleRepository.findById(id));
        role.setId(id);
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role deleteRole(String id){
        roleRepository.deleteById(id);
        return null;
    }

}
