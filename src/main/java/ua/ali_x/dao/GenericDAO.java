package ua.ali_x.dao;

import java.util.List;

public interface GenericDAO<T> {

    void create(T t);

    void delete(T t);

    void update(T t);

    void create(String t);

    void delete(Integer id);


    List<T> getAll();

}
