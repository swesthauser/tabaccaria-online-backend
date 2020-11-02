package tbz.modul151.tabaccariaonlinebackend.domainModels.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private Category findAllThrow (Optional<Category> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String id) {
        return findAllThrow(categoryRepository.findById(id));
    }

    @Override
    public Category createNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, String id) {
        findAllThrow(categoryRepository.findById(id));
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(String id) {
        categoryRepository.deleteById(id);
        return null;
    }
}
