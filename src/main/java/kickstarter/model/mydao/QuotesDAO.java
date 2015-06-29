package kickstarter.model.mydao;

import kickstarter.entities.Quote;
import kickstarter.model.mydao.exceptions.DBException;

public interface QuotesDAO extends DAO {
	
	Quote getRandomQuote() throws DBException;

}
