package kickstarter.model.dao.templates;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import kickstarter.model.dao.mappers.CategoryMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CategoryJDBCTemplate implements CategoryDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT id, `name` FROM categories";
        return jdbcTemplateObject.query(sql, new CategoryMapper());
    }

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public Category selectById(Integer id) {
        String sql = "SELECT id, `name` FROM categories WHERE id = ?";
        return jdbcTemplateObject.queryForObject(sql,
                new Object[]{id}, new CategoryMapper());
    }

    @Override
    public void create(Category entity) {
        String sql = "INSERT INTO categories (id, `name`) VALUE (?, ?)";
        Object[] args = {
                entity.getId()
        };
        jdbcTemplateObject.queryForObject(sql, args, new CategoryMapper());
    }

    @Override
    public void delete(Category entity) {
        String sql = "DELETE FROM categories WHERE id = ?";
        Object[] args = {
                entity.getId()
        };
        jdbcTemplateObject.update(sql, args);
    }

    @Override
    public void update(Category entity) {
        String sql = "UPDATE categories SET `name` = ? WHERE id = ?";
        Object[] args = {
                entity.getName(),
                entity.getId()
        };
        jdbcTemplateObject.update(sql, args);
    }
}
