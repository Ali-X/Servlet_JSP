package ua.ali_x.Service;

import ua.ali_x.Model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void create(String name);

    void delete(String name);

    void update(String old_name, String new_name);


}
