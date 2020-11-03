package tbz.modul151.tabaccariaonlinebackend.domainModels.article;

import tbz.modul151.tabaccariaonlinebackend.domainModels.article.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> getAllArticles();
    public Article getArticleById(String id);
    public Article createNewArticle (Article article);
    public Article updateArticle (Article article, String id);
    public Article deleteArticle(String id);
    public List<Article> findByCategoryId(String id);
    List<Article> findByUserId(String id);
}
