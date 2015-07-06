package kickstarter.servlets;

import kickstarter.entities.Project;
import kickstarter.model.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProjectServlet extends SpringInitedServlet {

    @Autowired
    ProjectService projectService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer projectId = Integer.parseInt(req.getParameter("project-id"));
        Project project = projectService.getById(projectId);
        req.setAttribute("project", project);
        req.getRequestDispatcher("jsp/project.jsp").forward(req, resp);
    }
}
