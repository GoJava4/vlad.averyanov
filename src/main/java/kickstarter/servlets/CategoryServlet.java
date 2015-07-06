package kickstarter.servlets;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.model.services.CategoryService;
import kickstarter.model.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends SpringInitedServlet {

    @Autowired
    ProjectService projectService;

    @Autowired
    CategoryService categoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(req.getParameter("category-id"));
        List<Project> projectList = projectService.getAllProjectsOfCategory(categoryId);
        Category category = categoryService.getById(categoryId);
        req.setAttribute("category", category);
        req.setAttribute("projectList", projectList);
        req.getRequestDispatcher("jsp/category.jsp").forward(req, resp);
    }
}
