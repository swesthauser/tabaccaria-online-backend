package tbz.modul151.tabaccariaonlinebackend.domainModels.role;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRoles();
    public Role getById(String id);
    public Role createNewRole (Role role);
    public Role updateRole (Role role, String id);
    public Role deleteRole(String id);
}
