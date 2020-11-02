package tbz.modul151.tabaccariaonlinebackend.domainModels.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /*
    @Transactional
    @Query(nativeQuery = true, value = "select * from public.users where email = :email and enabled = true")
    Optional<User> findByEmail(String email);

     */

    @Query(nativeQuery = true, value = "select * from public.users where email = ? and enabled = true")
    User findByEmail(String email);
}