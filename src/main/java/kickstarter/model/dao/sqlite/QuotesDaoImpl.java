package kickstarter.model.dao.sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.entities.Quote;
import kickstarter.model.dao.ConnectionPool;
import kickstarter.model.dao.QuotesDao;

public class QuotesDaoImpl implements QuotesDao {
	
	Connection connection;

	public QuotesDaoImpl(ConnectionPool connectionPool) {
		connection = connectionPool.getConnection();
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;
		try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT `context`, `author` FROM quotes ORDER BY RAND() LIMIT 0,1;");
			while (rs.next()){
				quote = new Quote(rs.getString("context"), rs.getString("author"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quote;
	}
}
