package ua.ali_x.dao;

import ua.ali_x.model.Category;
import ua.ali_x.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {

    public ProductDAOImpl(Connection connection) {
        super(connection);
    }

    public void create(String name, String description, Integer c_id) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "INSERT INTO PRODUCT (NAME, DESCRIPTION, C_ID) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, c_id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "DELETE FROM PRODUCT WHERE ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    public void update(Integer id, String new_name, String new_descr, String c_name) {
        int c_id = 0;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT ID FROM CATEGORY WHERE NAME = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, c_name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                c_id = rs.getInt(1);
            }
            preparedQuery = "UPDATE PRODUCT SET NAME = ?, DESCRIPTION = ?, C_ID = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, new_name);
            preparedStatement.setString(2, new_descr);
            preparedStatement.setInt(3, c_id);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }


    public List<Product> getAll(Integer c_id) {
        List<Product> list = new ArrayList<Product>();
        Product product = null;
        Integer id = null;
        String name = null;
        String description = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT * FROM PRODUCT WHERE C_ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, c_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("NAME");
                description = rs.getString("description");
                product = new Product(id, name, description, null);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void create(String t) {

    }

    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<Product>();
        Product product = null;
        Category category = null;
        Integer id = null;
        String name = null;
        String description = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT P.id as pid, P.name as pname, P.description, C.id as cid, C.name as cname FROM PRODUCT P JOIN Category C on P.c_id = C.id";
            preparedStatement = connection.prepareStatement(preparedQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                category = new Category(rs.getInt("cid"), rs.getString("CNAME"));
                id = rs.getInt("PID");
                name = rs.getString("PNAME");
                description = rs.getString("description");
                product = new Product(id, name, description, category);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProduct(Integer c_id, Integer p_id) {
        Product product = null;
        String name = null;
        String description = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT * FROM PRODUCT WHERE C_ID = ? AND ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, c_id);
            preparedStatement.setInt(2, p_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                name = rs.getString("NAME");
                description = rs.getString("description");
                product = new Product(p_id, name, description, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
