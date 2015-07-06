package kickstarter.model.dao.jdbctemplate.templates;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import junit.framework.Assert;
import kickstarter.entities.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:categoryTest/sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CategoryJDBCTemplateTest {

    @Autowired
    CategoryJDBCTemplate categoryJDBCTemplate;

    @Test
    public void testGetAllCategories() throws Exception {
        List<Category> categoryList = categoryJDBCTemplate.getAllCategories();
        Assert.assertEquals(3, categoryList.size());
    }

    @Test
    public void testSelectById() throws Exception {
        Category category = categoryJDBCTemplate.selectById(1);
        Assert.assertNotNull(category);
        Assert.assertEquals(1, category.getId());
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedCreateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "categories")
    public void testCreate() throws Exception {
        Category category = new Category("New Category");
        categoryJDBCTemplate.create(category);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedDeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "categories")
    public void testDelete() throws Exception {
        Category category = new Category(2, "New Category");
        categoryJDBCTemplate.delete(category);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:categoryTest/expectedUpdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "categories")
    public void testUpdate() throws Exception {
        Category category = new Category(2, "Updated Category");
        categoryJDBCTemplate.update(category);
    }
}