package tbz.modul151.tabaccariaonlinebackend.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return null;
    }

    @Override
    public Article getArticleById(String id) {
        return null;
    }

    @Override
    public Article createNewArticle(Article article) {
        return null;
    }

    @Override
    public Article updateArticle(Article article, String id) {
        return null;
    }

    @Override
    public Article deleteArticle(String id) {
        return null;
    }
}
