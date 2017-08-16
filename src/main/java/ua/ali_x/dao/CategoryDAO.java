package ua.ali_x.dao;

import ua.ali_x.model.Category;

public interface CategoryDAO extends GenericDAO<Category> {

    void update(Integer id, String new_name);

}
