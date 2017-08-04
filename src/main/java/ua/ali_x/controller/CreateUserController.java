package ua.ali_x.controller;

import ua.ali_x.Model.User;
import ua.ali_x.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserController extends AbstractController{

    private UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String token = userName + System.nanoTime();

        User user = new User(null, userName, password, email, token);
        userService.create(user);
        request.setAttribute("user", user);
        response.addCookie(new Cookie("token", user.getToken()));
    }
}
