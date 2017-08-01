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
}
