package ua.ali_x.controller;

import ua.ali_x.Model.User;
import ua.ali_x.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminController extends AbstractController{

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }
    public void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            if (userName.equals("admin") && password.equals("admin")) {
                User user = userService.findUser(userName, password);
                if (user != null) {
                    request.setAttribute("user", user);
                    response.addCookie(new Cookie("token", user.getToken()));
                    request.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
                }
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
