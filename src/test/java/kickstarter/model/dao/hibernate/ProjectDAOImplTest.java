package kickstarter.model.dao.hibernate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import junit.framework.Assert;
import kickstarter.entities.Category;
import kickstarter.entities.Project;
import kickstarter.model.dao.CategoryDAO;
import kickstarter.model.dao.ProjectDAO;
import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@DatabaseSetup(value = "classpath:sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class ProjectDAOImplTest {

    @Autowired
    ProjectDAO projectDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Test
    public void testGetAllProjectsOfCategory() throws Exception {
        List<Project> categoryList = projectDAO.getAllProjectsOfCategory(2);
        Assert.assertEquals(2, categoryList.size());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:projectTest/expectedCreateData.xml",
            table = "projects",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreate() throws Exception {
        Project project = new Project();
        project.setName("New Project");
        project.setMoneyGoal(0);
//        project.setAddingDate(new Date(new DateTime("2011-01-18 00:00:00.0")));
        projectDAO.create(project);
    }

    @Test
    public void testGetById() throws Exception {
        Project project = projectDAO.getById(2);
        Assert.assertEquals("Project 2", project.getName());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:projectTest/expectedUpdateData.xml",
            table = "projects",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() throws Exception {
        Project project = projectDAO.getById(1);
        project.setName("Updated Project");
        projectDAO.update(project);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:projectTest/expectedDeleteData.xml",
            table = "projects",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() throws Exception {
        Project project = projectDAO.getById(3);
        projectDAO.delete(project);
    }
}