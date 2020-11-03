package tbz.modul151.tabaccariaonlinebackend.domainModels.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    //@Query(nativeQuery = true, value = "select * from public.article where category_id = :id")
    List<Article> findByCategoryId(String id);

    @Query(nativeQuery = true, value = "select article_id from public.users_articles where users_id = :id")
    List<String> findByUserId(String id);
}
