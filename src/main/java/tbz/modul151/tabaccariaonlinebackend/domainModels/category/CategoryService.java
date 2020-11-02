package tbz.modul151.tabaccariaonlinebackend.domainModels.category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
    public Category getCategoryById(String id);
    public Category createNewCategory (Category category);
    public Category updateCategory (Category category, String id);
    public Category deleteCategory(String id);
}
