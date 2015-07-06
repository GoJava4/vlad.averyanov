package kickstarter.model.dao;

import kickstarter.entities.Quote;

public interface QuoteDAO extends DAO<Quote> {

    Quote getRandom();

}
