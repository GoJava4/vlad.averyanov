package kickstarter.model.services;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
})
public class ProjectServiceTest {

    @Mock
    ProjectDAO projectDAO;

    @InjectMocks
    ProjectService projectService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProjectsOfCategory() throws Exception {
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project());
        Mockito.when(projectDAO.getAllProjectsOfCategory(1)).thenReturn(projectList);
        assertEquals(projectList, projectService.getAllProjectsOfCategory(1));
    }

    @Test
    public void testGetById() throws Exception {
        Project project = new Project();
        Mockito.when(projectDAO.selectById(1)).thenReturn(project);
        assertEquals(project, projectService.getById(1));
    }
}