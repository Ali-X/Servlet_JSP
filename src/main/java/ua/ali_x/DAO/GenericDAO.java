package ua.ali_x.DAO;

public interface GenericDAO <T> {

    T create(T t);
    T delete(T t);
    T update(T t);
    T get(T t);

}
