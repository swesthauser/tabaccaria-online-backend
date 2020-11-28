package tbz.modul151.tabaccariaonlinebackend.domainModels.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    //@Query(nativeQuery = true, value = "select * from public.article where category_id = :id")
    List<Article> findByCategoryId(String id);

    @Query(
            value = "SELECT * FROM public.article RIGHT JOIN public.users_articles ON public.article.id = public.users_articles.article_id WHERE public.users_articles.users_id = :id",
            nativeQuery = true)
    List<Article> findByUserId(@Param("id") String id);
}
