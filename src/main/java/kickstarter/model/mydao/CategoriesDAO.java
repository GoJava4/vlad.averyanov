package kickstarter.model.mydao;

import java.util.List;

import kickstarter.entities.Category;
import kickstarter.model.mydao.exceptions.DBException;

public interface CategoriesDAO extends DAO {
	
	List<Category> getAllCategories() throws DBException;

	Category getCategoryById(int categoryId) throws DBException;

}
