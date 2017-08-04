package ua.ali_x.servlet;

import ua.ali_x.controller.*;
import ua.ali_x.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private GetUserController getUserController;
    private GetAllCategoriesController getAllCategoriesController;
    private CategoryController categoryController;
    private ProductController productController;
    private CreateUserController createUserController;
    private AdminController adminController;
    private HashMap<String, String> pages;

    public void init() {
        getUserController = Factory.getUserController();
        getAllCategoriesController = Factory.getAllCategoriesController();
        categoryController = Factory.getCategoryController();
        productController = Factory.getProductController();
        createUserController = Factory.getCreateUserController();
        adminController = Factory.getAdminController();
        pages = Factory.getPages();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        for (Map.Entry<String, String> page : pages.entrySet()) {
            if (request.getRequestURI().equals(page.getKey())) {
                switch (page.getKey()) {
                    case "/root/categories":
                        getAllCategoriesController.process(request, response);
                        request.getRequestDispatcher(page.getValue()).forward(request, response);
                        break;
                    case "/root/category":
                        categoryController.process(request, response);
                        break;
                    case "/root/product":
                        productController.process(request, response);
                        break;
                    case "/root/profile":
                        getAllCategoriesController.process(request, response);
                        request.getRequestDispatcher(page.getValue()).forward(request, response);
                        break;
                    case "/root/admin":
                        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher(page.getValue()).forward(request, response);
                        break;
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Map.Entry<String, String> page : pages.entrySet()) {
            if (request.getRequestURI().equals(page.getKey())) {
                switch (page.getKey()) {
                    case "/root/login":
                        adminController.process(request, response);
                        getAllCategoriesController.process(request, response);
                        getUserController.process(request, response);
                        break;
                    case "/root/registration":
                        createUserController.process(request, response);
                        getAllCategoriesController.process(request, response);
                        request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
                        break;
                }
            }
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}