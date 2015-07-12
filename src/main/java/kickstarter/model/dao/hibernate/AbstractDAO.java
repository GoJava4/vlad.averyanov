package kickstarter.model.dao.hibernate;

import kickstarter.model.dao.DAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDAO<T> implements DAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    Class<T> type;

    public AbstractDAO(Class<T> type) {
        this.type = type;
    }

    @Override
    public void create(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public T getById(Integer id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
