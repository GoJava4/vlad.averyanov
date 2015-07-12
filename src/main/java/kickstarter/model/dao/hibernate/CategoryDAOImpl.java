package kickstarter.model.dao.hibernate;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl extends AbstractDAO<Category> implements CategoryDAO {

    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> getAllCategories() {
        return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
    }
}
