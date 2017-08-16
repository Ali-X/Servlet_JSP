package ua.ali_x.service;

import ua.ali_x.dao.CategoryDAO;
import ua.ali_x.model.Category;

import java.util.List;

public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {

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

    public void delete(Integer id) {
        categoryDAO.delete(id);
    }

    @Override
    public void update(Integer id, String new_name) {
        categoryDAO.update(id, new_name);
    }
}
