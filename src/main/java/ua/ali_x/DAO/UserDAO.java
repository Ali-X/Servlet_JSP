package ua.ali_x.DAO;

import ua.ali_x.Model.User;

public interface UserDAO {

    User findByToken(String token);

    User findByNamePassword(String name, String password);

}
