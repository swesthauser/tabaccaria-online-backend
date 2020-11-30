package tbz.modul151.tabaccariaonlinebackend.domainModels.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tbz.modul151.tabaccariaonlinebackend.domainModels.article.Article;
import tbz.modul151.tabaccariaonlinebackend.domainModels.article.ArticleRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, ArticleRepository articleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = userRepository.findAll();
        return usersList;
    }

    @Override
    public User getUserById(String id) {
        return findAllThrow(userRepository.findById(id));
    }

    @Override
    public User createNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, String id) {
        User oldUser = findAllThrow(userRepository.findById(id));
        if(!oldUser.getPassword().equals(user.getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        user.setId(id);
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteUser(String id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User addArticleToFavorites(String userId, String articleId, User userToUpdate) {
        Optional<Article> articleToAdd = articleRepository.findById(articleId);
        Optional<User> optionalUser = userRepository.findById(userToUpdate.getId());
        if(articleToAdd != null && optionalUser != null){
            optionalUser.get().getArticles().add(articleToAdd.get());
            List<Article> newList = optionalUser.get().getArticles().stream().distinct().collect(Collectors.toList());
            optionalUser.get().setArticles(newList);
            return updateUser(optionalUser.get(), userId);
        } else throw new NoSuchElementException("Article or User don't exist");
    }

    public User removeArticleFromFavorites(String userId, String articleId, User userToUpdate) {
        Optional<Article> articleToRemove = articleRepository.findById(articleId);
        Optional<User> user = userRepository.findById(userToUpdate.getId());
        if (articleToRemove != null && user != null) {
            List<Article> currentFavorites = user.get().getArticles().stream().distinct().collect(Collectors.toList());
             if (currentFavorites.remove(articleToRemove.get())) {
                 user.get().setArticles(currentFavorites);
                 return updateUser(user.get(), userId);
             } else throw new NoSuchElementException("Article hasn't been able to be removed");
        } else throw new NoSuchElementException("Article or User don't exist");
    }

    private User findAllThrow (Optional<User> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return new UserDetailsImpl(findByEmail(username));
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username);
        }
    }

    /*@Override
    public User findByEmail(String email) {
        return findOrThrow(((UserRepository) repository).findByEmail(email));
    }
     */
}
