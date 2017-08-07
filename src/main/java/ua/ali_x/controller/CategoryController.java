package ua.ali_x.controller;

import ua.ali_x.Service.ProductService;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class CategoryController implements Controller {

    private ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        Integer idCategory = Integer.parseInt((String) vm.getAttribute("c_id"));
        vm.setAttribute("products", productService.getAll(idCategory));
        vm.setView("category");
        return vm;
    }
}
