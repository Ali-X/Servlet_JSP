package ua.ali_x.Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class User {

    static final Random rnd = new Random();
    private Integer id;
    private String userName;
    private String password;
    private String token;
    private String email;
    private Set<Roles> roles = new HashSet<Roles>();

    public User(Integer id, String userName, String password, String email, String token, Set<Roles> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.token = token;
        this.roles = roles;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getEmail() {
        return email;
    }

}
