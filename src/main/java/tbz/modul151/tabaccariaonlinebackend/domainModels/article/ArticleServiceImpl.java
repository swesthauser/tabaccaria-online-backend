package tbz.modul151.tabaccariaonlinebackend.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    private Article findAllThrow (Optional<Article> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(String id) {
        return findAllThrow(articleRepository.findById(id));
    }

    @Override
    public Article createNewArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article, String id) {
        findAllThrow(articleRepository.findById(id));
        article.setId(id);
        return articleRepository.save(article);
    }

    @Override
    public Article deleteArticle(String id) {
        articleRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Article> findByCategoryId(String id) {
        return articleRepository.findByCategoryId(id);
    }

    @Override
    public List<Article> findByUserId(String userId) {
        List<String> articleIds = articleRepository.findByUserId(userId);
        List<Article> articles = new ArrayList<>();
        for (String id : articleIds) {
            articles.add(getArticleById(id));
        }
        return articles;
    }
}
