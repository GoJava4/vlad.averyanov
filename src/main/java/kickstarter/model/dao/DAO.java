package kickstarter.model.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public interface DAO<T> {

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    T selectById(Integer id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
