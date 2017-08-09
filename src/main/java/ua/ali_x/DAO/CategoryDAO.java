package ua.ali_x.DAO;

import ua.ali_x.Model.Category;

import java.util.List;

public interface CategoryDAO extends GenericDAO<String> {

    List<Category> getAll();

    void update(String old_name, String new_name);

}
