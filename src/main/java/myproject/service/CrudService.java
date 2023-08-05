package myproject.service;

public interface CrudService <T>{
    void add(T t);
    T findById(int id);
    void update(T t);
    void deleteById(int id);
}
