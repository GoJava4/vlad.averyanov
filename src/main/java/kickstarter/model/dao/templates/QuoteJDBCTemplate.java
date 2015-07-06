package kickstarter.model.dao.templates;

import kickstarter.entities.Quote;
import kickstarter.model.dao.QuoteDAO;
import kickstarter.model.dao.mappers.QuoteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class QuoteJDBCTemplate implements QuoteDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Quote getRandom() {
        String sql = "SELECT id, content, author FROM quotes ORDER BY RAND() LIMIT 1";
         return jdbcTemplate.queryForObject(sql, new QuoteMapper());
    }

    @Override
    //don't need it
    public Quote selectById(Integer quoteId) {
        String SQL = "SELECT * FROM quotes WHERE id = ?";
         return jdbcTemplate.queryForObject(SQL,
                new Object[]{quoteId}, new QuoteMapper());
    }

    @Override
    public void create(Quote entity) {
        String sql = "INSERT INTO quotes (content, author) VALUE (?, ?)";
        jdbcTemplate.update(sql, entity.getContent(), entity.getAuthor());
    }

    @Override
    public void delete(Quote entity) {
        String sql = "DELETE FROM quotes WHERE (content = ? AND author = ?)";
        Object[] args = {
                entity.getContent(),
                entity.getAuthor()
        };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Quote entity) {
        String sql = "UPDATE quotes SET content = ?, author = ? WHERE id = ?";
        Object[] args = {
                entity.getContent(),
                entity.getAuthor(),
                entity.getId()
        };
        jdbcTemplate.update(sql, args);
    }
}
