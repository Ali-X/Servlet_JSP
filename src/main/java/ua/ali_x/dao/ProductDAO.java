package ua.ali_x.dao;

import ua.ali_x.model.Product;

import java.util.List;

public interface ProductDAO extends GenericDAO<Product> {

    List<Product> getAll(Integer c_id);

    List<Product> getAll();

    Product getProduct(Integer c_id, Integer p_id);

    void create(String name, String description, Integer c_id);

    void delete(Integer id);

    void update(Integer id, String new_name, String new_descr, String c_name);
}
