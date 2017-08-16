package ua.ali_x.service;

import ua.ali_x.dao.ProductDAO;
import ua.ali_x.model.Product;

import java.util.List;

public class ProductServiceImpl extends AbstractService<Product> implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAll(Integer c_id) {
        return productDAO.getAll(c_id);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public Product getProduct(Integer c_id, Integer p_id) {
        return productDAO.getProduct(c_id, p_id);
    }

    @Override
    public void create(String name, String description, Integer c_id) {
        productDAO.create(name, description, c_id);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }

    @Override
    public void update(Integer id, String new_name, String new_descr, String c_name) {
        productDAO.update(id, new_name, new_descr, c_name);
    }
}
