package service;

import java.util.List;

public interface IBaseService <T, ID>{
    List<T> findAll();
    T findById(ID id);
    void create(T entity);
    T update(T entity);
    void delete(T entity);
}
