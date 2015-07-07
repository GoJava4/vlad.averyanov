package kickstarter.model.dao;

public interface DAO<T> {

    T getById(Integer id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
