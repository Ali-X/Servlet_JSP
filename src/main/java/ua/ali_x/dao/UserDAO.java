package ua.ali_x.dao;

import ua.ali_x.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {

    User findByToken(String token);

    User findByNamePassword(String name, String password);

    List<User> getRoles();

    void setRole(Integer id, String role);

    void delRole(Integer id, String role);
}
