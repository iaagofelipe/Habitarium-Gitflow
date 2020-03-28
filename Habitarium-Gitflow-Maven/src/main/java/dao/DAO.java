package main.java.dao;

import java.util.List;

public interface DAO<T> {
    void save(T object);
    List get();
    T update(T object);
    void delete(T object);
}
