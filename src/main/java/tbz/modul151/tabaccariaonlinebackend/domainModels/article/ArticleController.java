package tbz.modul151.tabaccariaonlinebackend.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //GET
    @GetMapping("")
    @PreAuthorize("hasAuthority('RETRIEVE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<List<Article>> getAll(){
        return new ResponseEntity<List<Article>>(articleService.getAllArticles(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<Article> getById(@PathVariable String id){
        return new ResponseEntity<Article>(articleService.getArticleById(id), HttpStatus.OK);
    }

    //GET by CategoryId
    @GetMapping("/category/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<List<Article>>  getByCategoryId(@PathVariable String id){
        return new ResponseEntity<List<Article>>(articleService.findByCategoryId(id), HttpStatus.OK);
    }

    //GET by UserId
    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('RETRIEVE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<List<Article>>  getByUserId(@PathVariable String id){
        return new ResponseEntity<List<Article>>(articleService.findByUserId(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<Article> create(@RequestBody Article article) {
        return new ResponseEntity<Article>(articleService.createNewArticle(article), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<Article> update(@RequestBody Article article, @PathVariable String id){
        return new ResponseEntity<Article>(articleService.updateArticle(article, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ARTICLE')")
    public @ResponseBody
    ResponseEntity<Article> delete(@PathVariable String id){
        return new ResponseEntity<Article>(articleService.deleteArticle(id), HttpStatus.NO_CONTENT);
    }
}
