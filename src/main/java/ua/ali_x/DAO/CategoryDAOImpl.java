package ua.ali_x.DAO;

import ua.ali_x.Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl extends AbstractDAO<Category> implements CategoryDAO {

    public CategoryDAOImpl(Connection connection) {
        super(connection);
    }

    public Category create(Category category) {
        return category;
    }

    public Category delete(Category category) {
        return null;
    }

    public Category update(Category category) {
        return null;
    }

    public Category get(Category category) {
        return null;
    }

    public List<Category> getAll() {
        List<Category> list = new ArrayList<Category>();
        Category category = null;
        Integer id = null;
        String name = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT * FROM CATEGORY";
            preparedStatement = connection.prepareStatement(preparedQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("NAME");
                category = new Category(id, name);
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
