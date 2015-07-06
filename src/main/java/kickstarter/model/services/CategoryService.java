package kickstarter.model.services;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAllCategories(){
        return categoryDAO.getAllCategories();
    }

    public Category getById(Integer categoryId) {
        return categoryDAO.selectById(categoryId);
    }
}
