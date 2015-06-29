package kickstarter.model.mydao.mysql;

import kickstarter.entities.Quote;
import kickstarter.model.mydao.QuotesDAO;
import kickstarter.utilities.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuotesDAOMySQLImpl implements QuotesDAO {

    Connection connection;

    public QuotesDAOMySQLImpl(ConnectionPool connectionPool) {
        connection = connectionPool.getConnection();
    }

    @Override
    public Quote getRandomQuote() throws DBException {
        Quote quote = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT `content`, `author` FROM `quotes` ORDER BY RAND() LIMIT 1;");
            while (rs.next()){
                quote = new Quote(rs.getString("content"), rs.getString("author"));
            }
        } catch (SQLException e) {
            throw new DBException("Error while reading from DB, table quotes", e);
        }
        return quote;
    }
}

