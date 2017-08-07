package ua.ali_x.DAO;

import ua.ali_x.Model.Product;

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

    public Product create(Product item) {
        return null;
    }

    public Product delete(Product item) {
        return null;
    }

    public Product update(Product item) {
        return null;
    }

    public Product get(Product product) {
        return null;
    }

    public Product findById(Long id) {
        return null;
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
                product = new Product(id, name, description, c_id);
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
                product = new Product(p_id, name, description, c_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
