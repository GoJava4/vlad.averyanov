package kickstarter.model.services;

import kickstarter.entities.Quote;
import kickstarter.model.mydao.QuotesDAO;
import kickstarter.model.mydao.exceptions.DBException;
import org.springframework.beans.factory.annotation.Autowired;

public class QuoteService {

    @Autowired
    QuotesDAO quotesDAO;

    public QuoteService(QuotesDAO quotesDAO) {
        this.quotesDAO = quotesDAO;
    }

    public Quote getRandomQuote() throws DBException {
        return quotesDAO.getRandomQuote();
    }
}
