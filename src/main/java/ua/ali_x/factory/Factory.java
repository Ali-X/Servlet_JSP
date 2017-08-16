package ua.ali_x.factory;

import ua.ali_x.controller.*;
import ua.ali_x.controller.admin.*;
import ua.ali_x.controller.admin.dataBase.*;
import ua.ali_x.controller.category.CategoriesPageController;
import ua.ali_x.controller.category.CategoryController;
import ua.ali_x.controller.product.ProductController;
import ua.ali_x.controller.user.CreateUserController;
import ua.ali_x.controller.user.GetUserController;
import ua.ali_x.dao.*;
import ua.ali_x.service.*;
import ua.ali_x.servlet.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

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
        controllerMap.put(new Request("GET", "/root/admin/user"), Factory.getUserSettingsViewController());
        controllerMap.put(new Request("GET", "/root/admin/category"), Factory.getCategorySettingsViewController());
        controllerMap.put(new Request("GET", "/root/admin/product"), Factory.getProductSettingsViewController());

        controllerMap.put(new Request("POST", "/root/login"), Factory.getUserController());
        controllerMap.put(new Request("POST", "/root/registration"), Factory.getCreateUserController());

        controllerMap.put(new Request("POST", "/root/admin/category/add"), Factory.getC_addController());
        controllerMap.put(new Request("POST", "/root/admin/product/add"), Factory.getP_addController());
        controllerMap.put(new Request("GET", "/root/admin/category/del"), Factory.getC_delController());
        controllerMap.put(new Request("GET", "/root/admin/product/del"), Factory.getP_delController());
        controllerMap.put(new Request("POST", "/root/admin/category/upd"), Factory.getC_updController());
        controllerMap.put(new Request("GET", "/root/admin/category/upd"), Factory.getEditCategoryViewController());
        controllerMap.put(new Request("POST", "/root/admin/product/upd"), Factory.getP_updController());
        controllerMap.put(new Request("GET", "/root/admin/product/upd"), Factory.getEditProductViewController());
        controllerMap.put(new Request("GET", "/root/admin/user/del"), Factory.getU_delController());
        controllerMap.put(new Request("POST", "/root/admin/user/role/add"), Factory.getUr_addController());
        controllerMap.put(new Request("GET", "/root/admin/user/role/del"), Factory.getUr_delController());
        return controllerMap;
    }

    private static Controller getEditProductViewController() {
        return new EditProductViewController();
    }

    private static Controller getEditCategoryViewController() {
        return new EditCategoryViewController();
    }

    private static Controller getUr_delController() {
        return new ur_delController(Factory.getUserService());
    }

    private static Controller getUr_addController() {
        return new ur_addController(Factory.getUserService());
    }

    private static Controller getU_delController() {
        return new u_delController(Factory.getUserService());
    }

    private static Controller getProductSettingsViewController() {
        return new ProductSettingsViewController(Factory.getProductService(), Factory.getCategoriesService());
    }

    private static Controller getCategorySettingsViewController() {
        return new CategorySettingsViewController(Factory.getCategoriesService());
    }

    private static Controller getUserSettingsViewController() {
        return new UserSettingsViewController(Factory.getUserService());
    }

    private static Controller getP_updController() {
        return new p_updController(Factory.getProductService());
    }

    private static Controller getC_updController() {
        return new c_updController(Factory.getCategoriesService());
    }

    private static Controller getP_delController() {
        return new p_delController(Factory.getProductService());
    }

    private static Controller getC_delController() {
        return new c_delController(Factory.getCategoriesService());
    }

    private static Controller getP_addController() {
        return new p_addController(Factory.getProductService());
    }

    private static Controller getC_addController() {
        return new c_addController(Factory.getCategoriesService());
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

}
