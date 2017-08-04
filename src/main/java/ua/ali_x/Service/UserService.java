package ua.ali_x.Service;

import ua.ali_x.Model.User;

public interface UserService {

    User getUser (User user);
    User findUser(String name, String password);
    void create (User user);

}
