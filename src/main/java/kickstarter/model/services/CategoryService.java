package kickstarter.model.services;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> getAllCategories(){
        return categoryDAO.getAllCategories();
    }

    public Category getById(Integer categoryId) {
        return categoryDAO.getById(categoryId);
    }
}
