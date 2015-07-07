package kickstarter.model.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface DAO<T> {

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    T selectById(Integer id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
