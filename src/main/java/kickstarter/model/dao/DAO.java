package kickstarter.model.dao;

public interface DAO<T> {

    T selectById(Integer id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
