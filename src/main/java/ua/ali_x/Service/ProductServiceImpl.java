package ua.ali_x.Service;

import ua.ali_x.DAO.ProductDAO;
import ua.ali_x.Model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAll(Integer c_id) {
        return productDAO.getAll(c_id);
    }

    public Product getProduct(Integer c_id, Integer p_id) {
        return productDAO.getProduct(c_id, p_id);
    }
}
