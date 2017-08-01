package ua.ali_x.Service;

import ua.ali_x.DAO.CategoryDAO;
import ua.ali_x.Model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final CategoryDAO categoryDAO;

    public ProductServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Product> getAll(Long id) {
        return categoryDAO.getProducts(id);
    }
}
