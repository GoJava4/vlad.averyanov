package kickstarter.model.services;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectService")
@Transactional
public class ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    public List<Project> getAllProjectsOfCategory(Integer categoryId) {
        return projectDAO.getAllProjectsOfCategory(categoryId);
    }

    public Project getById(Integer projectId) {
        return projectDAO.getById(projectId);
    }
}
