package kickstarter.model.dao;

import kickstarter.entities.Project;

import java.util.List;

public interface ProjectDAO extends DAO<Project> {

    List<Project> getAllProjects();

    List<Project> getAllProjectsOfCategory(int categoryId);

}
