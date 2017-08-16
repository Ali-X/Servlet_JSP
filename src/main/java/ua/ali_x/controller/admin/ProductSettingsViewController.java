package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.CategoryService;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class ProductSettingsViewController implements Controller {
    private final ProductService productService;
    CategoryService categoryService;

    public ProductSettingsViewController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        vm.setAttribute("categories", categoryService.getAll());
        vm.setAttribute("products", productService.getAll());
        vm.setView("adminProduct");
        return vm;
    }
}
