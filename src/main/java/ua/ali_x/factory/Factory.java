package ua.ali_x.factory;

import ua.ali_x.DAO.*;
import ua.ali_x.Model.Category;
import ua.ali_x.Model.Product;
import ua.ali_x.Service.*;
import ua.ali_x.controller.GetAllCategoriesController;
import ua.ali_x.controller.ProductController;
import ua.ali_x.controller.UserController;

public class Factory {

    static CategoryDAO categoryDAO = new CategoryDAOImpl();
    static ProductDAO productDAO_fruit = new ProductDAOImpl();
    static ProductDAO productDAO_veg = new ProductDAOImpl();
    static ProductDAO productDAO_ber = new ProductDAOImpl();

    //user
    public static UserController getUserController() {
        return new UserController(Factory.getUserService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    private static UserDAOImpl getUserDao() {
        return new UserDAOImpl();
    }

    //category
    public static GetAllCategoriesController getAllCategoryController() {
        return new GetAllCategoriesController(Factory.getCategoryService());
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl(Factory.getCategoryDAO());
    }

    public static CategoryDAO getCategoryDAO() {
        productDAO_fruit.create(new Product(1L, "Apple", "Awesome"));
        productDAO_fruit.create(new Product(2L, "Apricot", "Awesome"));
        productDAO_fruit.create(new Product(3L, "Banana", "Awesome"));
        productDAO_veg.create(new Product(1L, "Aubergine", "Awesome"));
        productDAO_veg.create(new Product(2L, "Avocado", "Awesome"));
        productDAO_veg.create(new Product(3L, "Beetroot", "Awesome"));
        productDAO_ber.create(new Product(1L, "Barberry", "Awesome"));
        productDAO_ber.create(new Product(2L, "Bearberry", "Awesome"));
        productDAO_ber.create(new Product(3L, "Bilberry", "Awesome"));
        categoryDAO.create(new Category(1L, "fruit", productDAO_fruit.getAll()));
        categoryDAO.create(new Category(2L, "vegetable", productDAO_veg.getAll()));
        categoryDAO.create(new Category(3L, "berry", productDAO_ber.getAll()));
        return categoryDAO;
    }

    //product
    public static ProductService getProductService(){
        return new ProductServiceImpl(Factory.getProductDAO());
    }

    public static ProductController getProductController(){
        return new ProductController(Factory.getProductService());
    }

    public static CategoryDAO getProductDAO(){
        return categoryDAO;
    }
}
