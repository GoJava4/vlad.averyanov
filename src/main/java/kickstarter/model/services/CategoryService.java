package kickstarter.model.services;

import kickstarter.entities.Category;
import kickstarter.model.mydao.CategoriesDAO;
import kickstarter.model.mydao.exceptions.DBException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {

    @Autowired
    CategoriesDAO categoriesDAO;

    public CategoryService(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
    }

    public List<Category> getAllCategories() throws DBException {
        return categoriesDAO.getAllCategories();
    }
}
