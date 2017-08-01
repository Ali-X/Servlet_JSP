package ua.ali_x.DAO;

import ua.ali_x.Model.User;

import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl extends DAO<User> {

    private static final Set<User> userList = new HashSet<User>();

    static {
        userList.add(new User("Vova", "123123"));
        userList.add(new User("Anton", "123124"));
        userList.add(new User("Sergey", "123125"));
    }


    public User getUser(User user) {
        if (userList.contains(user)) {
            return user;
        } else {
            return null;
        }
    }

    public void create(User user) {
        return;
    }

    public User delete(User user) {
        return null;
    }

    public User update(User user) {
        return null;
    }

    public User findById(Long id) {
        return null;
    }
}
