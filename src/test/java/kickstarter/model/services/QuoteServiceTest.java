package kickstarter.model.services;

import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by User on 09.07.2015.
 */
public class QuoteServiceTest {

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
        Quote quote = new Quote();
        when(quoteService.getRandomQuote()).thenReturn(quote);
        assertEquals(quote, quoteService.getRandomQuote());
    }
}