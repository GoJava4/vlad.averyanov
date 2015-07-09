package kickstarter.model.services;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.mockito.Mockito.when;

public class ProjectServiceTest {

    @InjectMocks
    ProjectService projectService;

    @Mock
    ProjectDAO projectDAO;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProjectsOfCategory() throws Exception {
        when(projectDAO.getAllProjectsOfCategory(1)).thenReturn(new LinkedList<Project>());
        Assert.assertTrue(projectService.getAllProjectsOfCategory(1).size() == 0);
    }

    @Test
    public void testGetById() throws Exception {
        Project project = new Project();
        when(projectDAO.getById(1)).thenReturn(project);
        Assert.assertEquals(project, projectService.getById(1));
    }
}