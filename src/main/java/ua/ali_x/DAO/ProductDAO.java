package ua.ali_x.DAO;

import ua.ali_x.Model.Product;

import java.util.List;

public interface ProductDAO extends GenericDAO<Product> {

    List<Product> getAll(Integer c_id);

    Product getProduct(Integer c_id, Integer p_id);
}
