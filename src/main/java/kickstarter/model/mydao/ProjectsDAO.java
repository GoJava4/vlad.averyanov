package kickstarter.model.mydao;

import java.util.List;

import kickstarter.entities.Project;
import kickstarter.model.mydao.exceptions.DBException;

public interface ProjectsDAO extends DAO {

	List<Project> getAllProjects() throws DBException;
	
	List<Project> getAllProjectsOfCategory(int categoryId) throws DBException;

}
