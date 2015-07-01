package kickstarter.model.dao.mappers;

import kickstarter.entities.Quote;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteMapper implements RowMapper<Quote> {

    @Override
    public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Quote(
                rs.getString("content"),
                rs.getString("author")
        );
    }
}
