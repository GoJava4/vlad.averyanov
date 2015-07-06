package kickstarter.entities;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void testGetQuoteString() throws Exception {
        Quote quote = new Quote("content", "author");
        String quoteString = ("\"" + quote.getContent() + "\" " + quote.getAuthor());
        Assert.assertEquals(quoteString, quote.getQuoteString());
    }
}