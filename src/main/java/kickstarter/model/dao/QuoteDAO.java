package kickstarter.model.dao;

import kickstarter.entities.Quote;
import org.springframework.transaction.annotation.Transactional;

public interface QuoteDAO extends DAO<Quote> {

    Quote getRandom();

}
