package ua.ali_x.DAO;

import ua.ali_x.Model.Product;

import java.util.List;

public interface ProductDAO extends GenericDAO<String> {

    List<Product> getAll(Integer c_id);

    Product getProduct(Integer c_id, Integer p_id);

    void create(String name, String description, String c_name);

    void delete(String item);

    void update(String old_name, String new_name, String new_descr, String c_name);
}
