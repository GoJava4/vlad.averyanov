package kickstarter.model.dao.hibernate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import junit.framework.Assert;
import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@DatabaseSetup(value = "classpath:sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CategoryDAOImplTest {

    @Autowired
    CategoryDAO categoryDAO;

    @Test
    public void testGetAllCategories() throws Exception {
        List<Category> categoryList = categoryDAO.getAllCategories();
        Assert.assertEquals(3,categoryList.size());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:categoryTest/expectedCreateData.xml",
            table = "categories",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreate() throws Exception {
        Category category = new Category(4, "New Category");
        categoryDAO.create(category);
    }

    @Test
    public void testGetById() throws Exception {
        int id = 2;
        Category category = categoryDAO.getById(id);
        Assert.assertEquals("category 2", category.getName());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:categoryTest/expectedUpdateData.xml",
            table = "categories",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() throws Exception {
        Category category = new Category(2, "Updated category 2");
        categoryDAO.update(category);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:categoryTest/expectedDeleteData.xml",
            table = "categories",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() throws Exception {
        int id = 3;
        Category category = categoryDAO.getById(id);
        categoryDAO.delete(category);
    }
}