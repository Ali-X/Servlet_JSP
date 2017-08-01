package ua.ali_x.Service;

import ua.ali_x.DAO.UserDAOImpl;
import ua.ali_x.Model.User;

public class UserServiceImpl implements UserService {
    private UserDAOImpl userDao;

    public UserServiceImpl(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    public User getUser(User user) {
        return userDao.getUser(user);
    }
}
