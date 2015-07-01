package kickstarter.model.services;

import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class QuoteService {

    @Autowired
    QuoteDAO quoteDAO;

    public QuoteService(QuoteDAO quotesDAO) {
        this.quoteDAO = quotesDAO;
    }

    public Quote getRandomQuote() {
        return quoteDAO.getRandom();
    }
}
