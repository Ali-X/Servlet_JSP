package ua.ali_x.dao;

import ua.ali_x.model.Category;

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

    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "DELETE FROM CATEGORY WHERE ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    public void update(Integer id, String new_name) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "UPDATE CATEGORY SET NAME = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, new_name);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    @Override
    public void create(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void update(Category category) {

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
