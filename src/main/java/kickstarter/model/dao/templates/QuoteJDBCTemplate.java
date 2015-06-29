package kickstarter.model.dao.templates;

import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import kickstarter.model.dao.mappers.QuoteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class QuoteJDBCTemplate implements QuoteDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public Quote getRandom() {
        String sql = "SELECT content, author FROM quotes ORDER BY RAND() LIMIT 1";
        Quote quote = jdbcTemplateObject.queryForObject(sql, new QuoteMapper());
        return quote;
    }

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    //don't need it
    public Quote selectById(Integer quoteId) {
        String SQL = "SELECT * FROM quotes WHERE id = ?";
        Quote quote = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{quoteId}, new QuoteMapper());
        return quote;
    }

    @Override
    public void create(Quote entity) {
        String sql = "INSERT INTO quotes (content, author) VALUE (?, ?)";
        jdbcTemplateObject.update(sql, entity.getContent(), entity.getAuthor());
    }

    @Override
    public void delete(Quote entity) {
        String sql = "DELETE FROM quotes WHERE (content = ? AND author = ?)";
        Object[] args = {
                entity.getContent(),
                entity.getAuthor()
        };
        jdbcTemplateObject.update(sql, args);
    }

    @Override
    //don't need it
    public void update(Quote entity) {
        String sql = "UPDATE quotes SET content = ?, author = ? WHERE id = ?";
        Object[] args = {
                entity.getContent(),
                entity.getAuthor(),
                entity.getId()
        };
        jdbcTemplateObject.update(sql, args);
    }
}
