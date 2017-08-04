package ua.ali_x.factory;

import ua.ali_x.DAO.*;
import ua.ali_x.Service.*;
import ua.ali_x.controller.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class Factory {

    //db
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //user
    public static GetUserController getUserController() {
        return new GetUserController(Factory.getUserService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    public static UserDAOImpl getUserDao() {
        return new UserDAOImpl(Factory.getConnection());
    }

    //category
    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(Factory.getCategoriesService());
    }

    public static CategoryService getCategoriesService() {
        return new CategoryServiceImpl(Factory.getCategoryDAO());
    }

    public static CategoryDAO getCategoryDAO() {
        return new CategoryDAOImpl(Factory.getConnection());
    }

    //product
    public static ProductService getProductService() {
        return new ProductServiceImpl(Factory.getProductDAO());
    }

    public static CategoryController getCategoryController() {
        return new CategoryController(Factory.getProductService());
    }

    public static ProductDAO getProductDAO() {
        return new ProductDAOImpl(Factory.getConnection());
    }

    public static ProductController getProductController() {
        return new ProductController(Factory.getProductService());
    }

    public static CreateUserController getCreateUserController() {
        return new CreateUserController(Factory.getUserService());
    }

    //admin
    public static AdminController getAdminController() {
        return new AdminController(Factory.getUserService());
    }

    //pages
    public static HashMap<String, String> getPages(){
        HashMap<String, String> pages = new HashMap<>();
        pages.put("/root/admin", "/WEB-INF/views/admin.jsp");
        pages.put("/root/categories", "/WEB-INF/views/categories.jsp");
        pages.put("/root/category", "/WEB-INF/views/category.jsp");
        pages.put("/root/home", "/WEB-INF/views/home.jsp");
        pages.put("/root/login", "/WEB-INF/views/login.jsp");
        pages.put("/root/product", "/WEB-INF/views/product.jsp");
        pages.put("/root/registration", "/WEB-INF/views/registration.jsp");
        pages.put("/root/profile", "/WEB-INF/views/categories.jsp");
        return pages;
    }
}
