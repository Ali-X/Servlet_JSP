package ua.ali_x.DAO;

import ua.ali_x.Model.Category;
import ua.ali_x.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl extends DAO<Category> implements CategoryDAO {

    private List<Category> categories = new ArrayList<Category>();

    public void create(Category category) {
        categories.add(category);
    }

    public Category delete(Category category) {
        return null;
    }

    public Category update(Category category) {
        return null;
    }

    public Category findById(Long id) {
        return null;
    }

    public List<Category> getAll() {
        return categories;
    }

    public List<Product> getProducts(Long id) {
        for (Category category: categories) {
            if (category.getId().equals(id)) {
                return  category.getProductList();
            }
        }
        return null;
    }
}
