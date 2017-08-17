package ua.ali_x.service;

import ua.ali_x.dao.UserDAOImpl;
import ua.ali_x.model.Roles;
import ua.ali_x.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserServiceImpl extends AbstractService<User> implements UserService {
    private UserDAOImpl userDao;

    public UserServiceImpl(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    public User findUser(String name, String password) {
        return userDao.findByNamePassword(name, password);
    }

    public User findByToken(String token) {
        return userDao.findByToken(token);
    }

    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> getRoles() {
        return userDao.getRoles();
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void setRole(Integer id, String role) {
        userDao.setRole(id, role);
    }

    @Override
    public void delRole(Integer id, String role) {
        userDao.delRole(id, role);
    }

    @Override
    public Set<Roles> getAllRoles() {
        Class cls = Roles.class;
        Set<Roles> s = new HashSet<>();
        // returns the elements of this enum class
        for (Object obj : cls.getEnumConstants()) {
            s.add((Roles) obj);
        }
        return s;
    }

    @Override
    public void update(Integer id, String username, String password, String email) {
        userDao.update(new User(id, username, password, email, null, null));
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
