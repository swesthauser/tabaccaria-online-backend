package tbz.modul151.tabaccariaonlinebackend.domainModels.user;


import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();
    public User getUserById(String id);
    public User createNewUser (User user);
    public User updateUser (User user, String id);
    public User deleteUser(String id);

    User findByEmail(String email);
}
