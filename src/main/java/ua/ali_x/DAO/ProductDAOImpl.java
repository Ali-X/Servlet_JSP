package ua.ali_x.DAO;

import ua.ali_x.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private List<Product> products = new ArrayList<Product>();

    public void create(Product item) {
        products.add(item);
    }
    public Product delete(Product item) {
        return null;
    }

    public Product update(Product item) {
        return null;
    }

    public Product findById(Long id) {
        return null;
    }

    public List<Product> getAll() {
        return products;
    }
}
