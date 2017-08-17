package ua.ali_x.dao;

import ua.ali_x.model.Roles;
import ua.ali_x.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    public UserDAOImpl(Connection connection) {
        super(connection);
    }

    public void create(User user) {
        Integer userid = null;
        Integer roleid = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "INSERT INTO USERS (USERNAME, TOKEN, PASSWORD, EMAIL) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getToken());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.execute();

            preparedQuery = "SELECT U.ID FROM USERS U WHERE U.USERNAME = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, user.getUserName());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userid = rs.getInt("ID");
            }
            for (Roles r : user.getRoles()
                    ) {
                preparedQuery = "SELECT R.ID FROM ROLES R WHERE R.NAME = ?";
                preparedStatement = connection.prepareStatement(preparedQuery);
                preparedStatement.setString(1, r.name());
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    roleid = rs.getInt("ID");
                }
                preparedQuery = "INSERT INTO USERTOROLE (USERID, ROLEID) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(preparedQuery);
                preparedStatement.setInt(1, userid);
                preparedStatement.setInt(2, roleid);
                preparedStatement.execute();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    public void delete(User user) {

    }

    public void update(User user) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "UPDATE USERS " +
                    "SET USERNAME = ?, PASSWORD = ?, EMAIL = ? " +
                    "WHERE ID = ?;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    @Override
    public void create(String t) {

    }

    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "DELETE FROM USERS WHERE ID = ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    @Override
    public List<User> getAll() {
        Integer id = null;
        String email = null;
        String username = null;
        String password = null;
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT  U.ID, U.USERNAME, U.PASSWORD, U.EMAIL " +
                    "FROM USERS U;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                email = rs.getString("EMAIL");
                username = rs.getString("username");
                password = rs.getString("password");
                users.add(new User(id, username, password, email, null, null));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return users;
    }

    public List<User> getRoles() {
        Integer id = null;
        String email = null;
        String username = null;
        String password = null;
        Set<Roles> roles = null;
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT  U.ID, U.USERNAME, U.PASSWORD, U.EMAIL, R.NAME " +
                    "FROM USERS U " +
                    "JOIN USERTOROLE UR ON UR.USERID=U.ID " +
                    "JOIN ROLES R ON R.ID = UR.ROLEID;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                email = rs.getString("EMAIL");
                username = rs.getString("username");
                password = rs.getString("password");
                roles = new HashSet<Roles>();
                roles.add(Roles.valueOf(rs.getString("NAME")));
                users.add(new User(id, username, password, email, null, roles));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return users;
    }

    @Override
    public void setRole(Integer userID, String role) {
        Integer roleID = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT R.ID FROM ROLES R WHERE R.NAME = ?;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, role);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roleID = rs.getInt("ID");
            }
            preparedQuery = "INSERT INTO USERTOROLE (USERID, ROLEID) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, roleID);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
    }

    @Override
    public void delRole(Integer id, String role) {
        Integer roleID = null;
        try {
            PreparedStatement preparedStatement;
            String preparedQuery = "SELECT R.ID FROM ROLES R WHERE R.NAME = ?;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, role);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roleID = rs.getInt("ID");
            }
            preparedQuery = "DELETE FROM USERTOROLE WHERE USERID = ? AND ROLEID = ?;";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, roleID);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
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
                user = new User(id, name, password, email, token, roles);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("There are problems with authentication" + e);
        }
        return user;
    }
}
