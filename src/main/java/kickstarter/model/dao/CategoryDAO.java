package kickstarter.model.dao;

import kickstarter.entities.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryDAO extends DAO<Category> {

    @Transactional
    List<Category> getAllCategories();

}
