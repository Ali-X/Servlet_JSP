package ua.ali_x.Service;

import ua.ali_x.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll(Integer id);
    Product getProduct(Integer c_id, Integer p_id);

}
