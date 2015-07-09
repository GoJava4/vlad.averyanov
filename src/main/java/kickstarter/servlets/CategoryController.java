package kickstarter.servlets;

import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.model.services.CategoryService;
import kickstarter.model.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ProjectService projectService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/{categoryId}")
    public String showCategory(ModelMap model, @PathVariable int categoryId) {
        List<Project> projectList = projectService.getAllProjectsOfCategory(categoryId);
        Category category = categoryService.getById(categoryId);

        model.addAttribute("category", category);
        model.addAttribute("projectList", projectList);

        return "category.jsp";
    }
}
