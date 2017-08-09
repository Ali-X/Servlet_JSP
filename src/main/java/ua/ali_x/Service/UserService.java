package ua.ali_x.Service;

import ua.ali_x.Model.User;

public interface UserService {

    User findUser(String name, String password);

    User findByToken(String token);

    void create(User user);

}
