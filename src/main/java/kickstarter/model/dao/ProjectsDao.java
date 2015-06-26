package kickstarter.model.dao;

import java.util.List;

import kickstarter.entities.Project;

public interface ProjectsDao {

	List<Project> getAllProjects();
	
	List<Project> getAllProjectsOfCategory(int categoryId);

}
