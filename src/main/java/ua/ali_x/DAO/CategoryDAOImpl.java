package ua.ali_x.DAO;

import ua.ali_x.Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl extends AbstractDAO<String> implements CategoryDAO {

    public CategoryDAOImpl(Connection connection) {
        super(connection);
    }

    public void create(String category) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "INSERT INTO CATEGORY (NAME) VALUES(?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, category);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    public void delete(String category) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "DELETE FROM CATEGORY WHERE NAME = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, category);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    @Override
    public void update(String s) {

    }

    public void update(String old_name, String new_name) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "UPDATE CATEGORY SET NAME = ? WHERE NAME = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, new_name);
            preparedStatement.setString(2, old_name);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
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
