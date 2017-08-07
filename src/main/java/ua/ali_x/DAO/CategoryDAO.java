package ua.ali_x.DAO;

import ua.ali_x.Model.Category;

import java.util.List;

public interface CategoryDAO extends GenericDAO<Category> {

    List<Category> getAll();

}
