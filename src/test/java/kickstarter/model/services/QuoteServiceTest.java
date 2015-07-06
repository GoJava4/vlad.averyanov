package kickstarter.model.services;

import junit.framework.TestCase;
import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
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

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
})
public class QuoteServiceTest extends TestCase {

    @Mock
    QuoteDAO quoteDAO;

    @InjectMocks
    QuoteService quoteService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRandomQuote() throws Exception {
        Quote quote = new Quote("content 1", "author 1");
        Mockito.when(quoteDAO.getRandom()).thenReturn(quote);
        assertEquals(quote, quoteService.getRandomQuote());
    }
}