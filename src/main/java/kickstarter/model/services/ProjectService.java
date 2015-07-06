package kickstarter.model.services;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public List<Project> getAllProjectsOfCategory(Integer categoryId) {
        return projectDAO.getAllProjectsOfCategory(categoryId);
    }

    public Project getById(Integer projectId) {
        return projectDAO.selectById(projectId);
    }
}
