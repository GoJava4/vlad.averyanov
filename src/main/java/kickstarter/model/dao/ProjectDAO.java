package kickstarter.model.dao;

import kickstarter.entities.Project;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectDAO extends DAO<Project> {

    List<Project> getAllProjectsOfCategory(int categoryId);

}
