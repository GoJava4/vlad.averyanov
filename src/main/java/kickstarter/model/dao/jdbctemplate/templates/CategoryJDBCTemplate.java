package kickstarter.model.dao.jdbctemplate.templates;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import kickstarter.model.dao.jdbctemplate.mappers.CategoryMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryJDBCTemplate implements CategoryDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT id, `name` FROM categories";
        return jdbcTemplate.query(sql, new CategoryMapper());
    }

    @Override
    public Category selectById(Integer id) {
        String sql = "SELECT id, `name` FROM categories WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new CategoryMapper());
    }

    @Override
    public void create(Category entity) {
        String sql = "INSERT INTO categories (`name`) VALUE (?)";
        Object[] args = {
                entity.getName()
        };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void delete(Category entity) {
        String sql = "DELETE FROM categories WHERE id = ?";
        Object[] args = {
                entity.getId()
        };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Category entity) {
        String sql = "UPDATE categories SET `name` = ? WHERE id = ?";
        Object[] args = {
                entity.getName(),
                entity.getId()
        };
        jdbcTemplate.update(sql, args);
    }
}
