package tbz.modul151.tabaccariaonlinebackend.domainModels.user;


import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();
    public User getUserById(String id);
    public User createNewUser (User user);
    public User updateUser (User user, String id);
    public User deleteUser(String id);
    public User findByEmail(String email);
    public void addArticleToFavorites(String userId, String articleId, User userToUpdate);
}
