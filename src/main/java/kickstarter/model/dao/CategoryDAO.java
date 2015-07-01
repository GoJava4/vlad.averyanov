package kickstarter.model.dao;

import kickstarter.entities.Category;

import java.util.List;

public interface CategoryDAO extends DAO<Category> {

    List<Category> getAllCategories();

}
