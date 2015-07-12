package kickstarter.model.dao;

import kickstarter.entities.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryDAO extends DAO<Category> {

    List<Category> getAllCategories();

}
