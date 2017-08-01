package ua.ali_x.DAO;

public interface GenericDAO <T> {

    void create(T t);
    T delete(T t);
    T update(T t);
    T findById(Long id);

}
