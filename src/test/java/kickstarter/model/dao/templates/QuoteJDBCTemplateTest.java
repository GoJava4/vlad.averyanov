package kickstarter.model.dao.templates;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import kickstarter.entities.Quote;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:quoteTest/sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class QuoteJDBCTemplateTest {

    @Autowired
    QuoteJDBCTemplate quoteJDBCTemplate;

    @Test
    public void testGetRandom() throws Exception {
        Quote quote = quoteJDBCTemplate.getRandom();
        Assert.assertNotNull(quote);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:quoteTest/expectedCreateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "quotes")
    public void testCreate() throws Exception {
        Quote quote = new Quote("New Content", "New Author");
        quoteJDBCTemplate.create(quote);
    }

    @Test
    public void testSelectById() throws Exception {
        Quote quote = quoteJDBCTemplate.getRandom();
        Assert.assertNotNull(quote);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:quoteTest/expectedDeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "quotes")
    public void testDelete() throws Exception {
        Quote quote = new Quote("quote 2", "author 2");
        quoteJDBCTemplate.delete(quote);
    }

    @Test
    @ExpectedDatabase(
            value = "classpath:quoteTest/expectedUpdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT,
            table = "quotes")
    public void testUpdate() throws Exception {
        Quote quote = quoteJDBCTemplate.selectById(2);
        quote.setContent("Updated Content");
        quote.setAuthor("Updated Author");
        quoteJDBCTemplate.update(quote);
    }
}