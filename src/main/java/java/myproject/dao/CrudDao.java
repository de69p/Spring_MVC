package java.myproject.dao;

import java.util.List;

public interface CrudDao<T> {

    void add(T entity);

    T findById(Integer id);

    List<T> findAll();

    void update(T entity);

    void delete(Integer id);
}
