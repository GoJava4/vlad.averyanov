package kickstarter.model.dao.hibernate;

import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("quoteDAO")
public class QuoteDAOImpl extends AbstractDAO<Quote> implements QuoteDAO {

    public QuoteDAOImpl() {
        super(Quote.class);
    }

    @Override
    public Quote getRandom() {
        Session currentSession = sessionFactory.getCurrentSession();
        return (Quote) currentSession.createSQLQuery("SELECT * FROM quotes ORDER BY RAND() LIMIT 1").addEntity(Quote.class).uniqueResult();
    }
}
