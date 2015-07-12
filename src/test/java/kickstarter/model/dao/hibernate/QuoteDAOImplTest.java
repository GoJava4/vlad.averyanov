package kickstarter.model.dao.hibernate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import org.junit.Assert;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@DatabaseSetup(value = "classpath:sampleData.xml", type = DatabaseOperation.CLEAN_INSERT)
public class QuoteDAOImplTest {

    @Autowired
    private QuoteDAO quoteDAO;

    @Test
    public void testGetRandom() throws Exception {
        Quote quote = quoteDAO.getRandom();
        Assert.assertNotNull(quote);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:quoteTest/expectedCreateData.xml",
            table = "quotes",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreate() throws Exception {
        Quote quote = new Quote("New Content","New Author");
        quoteDAO.create(quote);
    }

    @Test
    public void testGetById() throws Exception {
        Quote quote = new Quote("quote 1","author 1");
        Assert.assertEquals(quote.getContent(), quoteDAO.getById(1).getContent());
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:quoteTest/expectedUpdateData.xml",
            table = "quotes",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() throws Exception {
        int id = 2;
        Quote quote = quoteDAO.getById(id);

        quote.setContent("Updated Content");
        quote.setAuthor("Updated Author");

        quoteDAO.update(quote);
    }

    @Test
    @Rollback(false)
    @ExpectedDatabase(value = "classpath:quoteTest/expectedDeleteData.xml",
            table = "quotes",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() throws Exception {
        int id = 2;
        Quote quote = quoteDAO.getById(id);
        quoteDAO.delete(quote);
    }
}