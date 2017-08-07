package ua.ali_x.factory;

import ua.ali_x.DAO.*;
import ua.ali_x.Service.*;
import ua.ali_x.controller.*;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class Factory {

    private static ViewModel vm = new ViewModel();

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
        return new GetUserController(Factory.getUserService(), Factory.getCategoriesService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    public static UserDAOImpl getUserDao() {
        return new UserDAOImpl(Factory.getConnection());
    }

    //category
    public static CategoriesPageController getCategoriesPageController() {
        return new CategoriesPageController(Factory.getCategoriesService());
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
        return new CreateUserController(Factory.getUserService(), Factory.getCategoriesService());
    }

    //admin
    public static AdminController getAdminController() {
        return new AdminController(Factory.getUserService());
    }

    public static Map<Request, Controller> getControllerMap() {
        Map<Request, Controller> controllerMap = new HashMap<>();
        controllerMap.put(new Request("GET", "/root/home"), Factory.getHomeController());
        controllerMap.put(new Request("GET", "/root/admin"), Factory.getAdminController());
        controllerMap.put(new Request("GET", "/root/categories"), Factory.getCategoriesPageController());
        controllerMap.put(new Request("GET", "/root/category"), Factory.getCategoryController());
        controllerMap.put(new Request("GET", "/root/login"), Factory.getLoginPageController());
        controllerMap.put(new Request("GET", "/root/product"), Factory.getProductController());
        controllerMap.put(new Request("GET", "/root/registration"), Factory.getRegistrationPageController());
        controllerMap.put(new Request("GET", "/root/profile"), Factory.getProfileController());
        controllerMap.put(new Request("POST", "/root/login"), Factory.getUserController());
        controllerMap.put(new Request("POST", "/root/registration"), Factory.getCreateUserController());
        return controllerMap;
    }

    private static Controller getProfileController() {
        return new ProfileController(Factory.getUserService(), Factory.getCategoriesService());
    }

    private static Controller getRegistrationPageController() {
        return new RegistrationPageController();
    }

    private static Controller getLoginPageController() {
        return new LoginPageController();
    }

    private static Controller getHomeController() {
        return new HomePageController();
    }

    public static ViewModel getViewModel() {
        return vm;
    }
}
