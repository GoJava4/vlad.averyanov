package kickstarter.model.dao.hibernate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import junit.framework.Assert;
import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
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
@DatabaseSetup(value = "classpath:categoryTest/sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CategoryDAOImplTest {

    @Autowired
    CategoryDAO categoryDAO;

    @Test
    public void testGetAllCategories() throws Exception {
        List<Category> allCategories = categoryDAO.getAllCategories();
        Assert.assertTrue(allCategories.size() > 1);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedCreateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "categories")
    public void testCreate() throws Exception {
        Category category = new Category(1, "New Category");
        categoryDAO.create(category);
    }

    @Test
    public void testGetById() throws Exception {
        Category category = new Category(1, "category 1");
        Assert.assertEquals(category.getName(), categoryDAO.getById(1).getName());
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedUpdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "categories")
    public void testUpdate() throws Exception {
        Category category = new Category(2, "Updated category 2");
        categoryDAO.update(category);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedDeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "categories")
    public void testDelete() throws Exception {
        //Удаляет по ай-ди, название не важно
        Category category = new Category(2, "Random name");
        categoryDAO.delete(category);
    }
}