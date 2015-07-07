package kickstarter.model.dao;

import javax.sql.DataSource;

public interface DAO<T> {

    void setDataSource(DataSource ds);

    T selectById(Integer id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
