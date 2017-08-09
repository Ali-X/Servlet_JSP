package ua.ali_x.Service;

import ua.ali_x.DAO.CategoryDAO;
import ua.ali_x.Model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public void create(String name) {
        categoryDAO.create(name);
    }

    @Override
    public void delete(String name) {
        categoryDAO.delete(name);
    }

    @Override
    public void update(String old_name, String new_name) {
        categoryDAO.update(old_name, new_name);
    }
}
