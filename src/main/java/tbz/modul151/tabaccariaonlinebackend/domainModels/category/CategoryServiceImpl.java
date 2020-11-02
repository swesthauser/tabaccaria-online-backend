package tbz.modul151.tabaccariaonlinebackend.domainModels.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category getCategoryById(String id) {
        return null;
    }

    @Override
    public Category createNewCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category, String id) {
        return null;
    }

    @Override
    public Category deleteCategory(String id) {
        return null;
    }
}
