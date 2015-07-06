package kickstarter.model.dao.jdbctemplate.templates;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import kickstarter.entities.Project;
import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:projectTest/sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class ProjectJDBCTemplateTest {

    @Autowired
    ProjectJDBCTemplate projectJDBCTemplate;

    @Test
    public void testGetAllProjects() throws Exception {
        List<Project> projectList = projectJDBCTemplate.getAllProjects();
        assertEquals(6, projectList.size());
    }

    @Test
    public void testGetAllProjectsOfCategory() throws Exception {
        List<Project> projectList = projectJDBCTemplate.getAllProjectsOfCategory(2);
        assertEquals(2, projectList.size());
    }

    @Test
    public void testSelectById() throws Exception {
        Project project = new Project(1, 1, "Project 1", "Short Descr 1", 5000, 1000, 30, null, "Full Descr 1", "Video Url 1");
        assertEquals(project.getName(), projectJDBCTemplate.selectById(1).getName());
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:projectTest/expectedCreateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "projects")
    public void testCreate() throws Exception {
        System.out.println(new DateTime(100).getMillis());
        Project project = new Project();
        //TODO Make it work by conversion DateTime to MySQL format
        project.setName("New Project");
        projectJDBCTemplate.create(project);
    }

    @Test
    @Ignore
    public void testDelete() throws Exception {

    }

    @Test
    @Ignore
    public void testUpdate() throws Exception {

    }
}