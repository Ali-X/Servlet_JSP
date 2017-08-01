package ua.ali_x.controller;

import ua.ali_x.Model.User;
import ua.ali_x.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");
        User user = new User(userName, pass);
        if (userService.getUser(user) != null) {
            request.setAttribute("user" , user);
            request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
        } else {
            throw new RuntimeException("User " + user + " doesn't exist");
        }
    }
}
