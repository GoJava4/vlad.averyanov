package kickstarter.model.services;

import kickstarter.model.dao.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by User on 29.06.2015.
 */
public class ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
}
