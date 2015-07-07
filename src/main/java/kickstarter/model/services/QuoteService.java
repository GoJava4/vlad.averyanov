package kickstarter.model.services;

import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("quoteService")
public class QuoteService {

    @Autowired
    QuoteDAO quoteDAO;

    public Quote getRandomQuote() {
        return quoteDAO.getRandom();
    }
}
