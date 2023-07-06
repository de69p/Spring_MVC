package java.myproject.service;

import java.util.List;

public interface CrudService<T> {

    void add(T entity);

    T findById(Integer id);

    List<T> findAll();

    void update(T entity);

    void delete(Integer id);
}
