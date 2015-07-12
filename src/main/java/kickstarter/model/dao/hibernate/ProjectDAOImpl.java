package kickstarter.model.dao.hibernate;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("projectDAO")
public class ProjectDAOImpl extends AbstractDAO<Project> implements ProjectDAO {

    public ProjectDAOImpl() {
        super(Project.class);
    }

    @Override
    public List<Project> getAllProjectsOfCategory(int categoryId) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Project> list = currentSession.createCriteria(Project.class)
                .add(Restrictions.eq("category.id", categoryId))
                .addOrder(Order.asc("name"))
                .list();
        return list;
    }
}
