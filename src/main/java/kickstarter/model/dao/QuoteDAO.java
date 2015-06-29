package kickstarter.model.dao;

import kickstarter.entities.Quote;

public interface QuoteDAO extends DAO<Quote> {

    public Quote getRandom();

}
