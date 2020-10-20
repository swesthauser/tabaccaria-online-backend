package tbz.modul151.tabaccariaonlinebackend.domainModels.role;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    public Role getById(String id){
        return null;
    }

    @Override
    public Role createNewRole (Role role){
        return null;
    }

    @Override
    public Role updateRole (Role role, String id){
        return null;
    }

    @Override
    public Role deleteRole(String id){
        return null;
    }

}
