package ua.ali_x.DAO;

import org.h2.jdbc.JdbcSQLException;
import ua.ali_x.Model.Roles;
import ua.ali_x.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    public UserDAOImpl(Connection connection) {
        super(connection);
    }

    public User get(User user) {
        return null;
    }

    public User create(User user) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "INSERT INTO USERS (USERNAME, TOKEN, PASSWORD, EMAIL) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getToken());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return user;
    }

    public User delete(User user) {
        return null;
    }

    public User update(User user) {
        return null;
    }

    public User getUser(User user) {
        return null;
    }

    public User findByToken(String token) {
        User user = null;
        Integer id = null;
        String name = null;
        String password = null;
        String email = null;
        Set<Roles> roles = new HashSet<Roles>();
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT  U.ID, U.USERNAME, U.PASSWORD, U.TOKEN, U.EMAIL, R.NAME " +
                    "FROM USERS U " +
                    "JOIN USERTOROLE UR ON UR.USERID=U.ID " +
                    "JOIN ROLES R ON R.ID = UR.ROLEID " +
                    "WHERE U.TOKEN = ?;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, token);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("USERNAME");
                password = rs.getString("PASSWORD");
                email = rs.getString("EMAIL");
                roles.add(Roles.valueOf(rs.getString("NAME")));
            }
            preparedStatement.close();
            user = new User(id, name, password, email, token, roles);
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return user;
    }

    public User findByNamePassword(String name, String password) {
        User user = null;
        Integer id = null;
        String email = null;
        String token = null;
        Set<Roles> roles = new HashSet<Roles>();
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT  U.ID, U.USERNAME, U.PASSWORD, U.TOKEN, U.EMAIL, R.NAME " +
                    "FROM USERS U " +
                    "JOIN USERTOROLE UR ON UR.USERID=U.ID " +
                    "JOIN ROLES R ON R.ID = UR.ROLEID " +
                    "WHERE U.USERNAME = ? " +
                    "AND U.PASSWORD = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                email = rs.getString("EMAIL");
                token = rs.getString("TOKEN");
                roles.add(Roles.valueOf(rs.getString("NAME")));
            }
            preparedStatement.close();
            user = new User(id, name, password, email, token, roles);
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return user;
    }
}
