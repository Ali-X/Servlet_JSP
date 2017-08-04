package ua.ali_x.filter;

import ua.ali_x.DAO.UserDAOImpl;
import ua.ali_x.Model.User;
import ua.ali_x.factory.Factory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminFilter implements Filter{

    private UserDAOImpl userDAO;
    private final String TOKEN = "token";
    private List<String> protectedUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDAO = Factory.getUserDao();
        protectedUrls.add("/root/admin");
        protectedUrls.add("/root/profile");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        String uri = httpServletRequest.getRequestURI();

        if (protectedUrls.contains(uri)) {
            String token = null;
            Boolean iAmAdmin;
            for (Cookie cookie : cookies) {
                String name = cookie.getName().toLowerCase();
                if (TOKEN.equals(name)){
                    token = cookie.getValue();
                    iAmAdmin = userDAO.isAdmin(userDAO.findByToken(token));
                    User user = userDAO.findByToken(token);
                    request.setAttribute("user", user);
                    if (iAmAdmin) {
                        request.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
                    }
                }
            }
            if (token == null) {
                    request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
