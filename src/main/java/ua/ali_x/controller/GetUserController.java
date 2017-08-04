package ua.ali_x.controller;

import ua.ali_x.Model.User;
import ua.ali_x.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUserController extends AbstractController {

    private UserService userService;

    public GetUserController(UserService userService) {
        this.userService = userService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");
        User user = userService.findUser(userName, pass);
        if (user != null) {
            request.setAttribute("user", user);
            response.addCookie(new Cookie("token", user.getToken()));
            request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
