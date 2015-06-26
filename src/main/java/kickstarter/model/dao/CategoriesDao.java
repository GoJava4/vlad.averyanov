package kickstarter.model.dao;

import java.util.List;

import kickstarter.entities.Category;

public interface CategoriesDao {
	
	List<Category> getAllCategories();

	Category getCategoryById(int categoryId);

}
