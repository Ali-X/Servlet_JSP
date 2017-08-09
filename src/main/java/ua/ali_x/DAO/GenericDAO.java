package ua.ali_x.DAO;

public interface GenericDAO<T> {

    void create(T t);

    void delete(T t);

    void update(T t);

}
