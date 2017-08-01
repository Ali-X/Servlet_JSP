package ua.ali_x.servlet;

import ua.ali_x.controller.GetAllCategoriesController;
import ua.ali_x.controller.ProductController;
import ua.ali_x.controller.UserController;
import ua.ali_x.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private UserController userController;
    private GetAllCategoriesController getAllCategoriesController;
    private ProductController productController;

    public void init() {
        userController = Factory.getUserController();
        getAllCategoriesController = Factory.getAllCategoryController();
        productController = Factory.getProductController();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/home")) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/login")) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/login")) {
            getAllCategoriesController.process(request, response);
            userController.getUser(request, response);
  //          request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/categories")) {
            request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
        }

        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/categories")) {
            request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/category")) {
            productController.process(request, response);
        }

       /* if (request.getMethod().equals("POST") && request.getRequestURI().equals("/categories")) {
            productController.process(request, response);
        }*/

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/products")) {
           request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
        }

    }
}