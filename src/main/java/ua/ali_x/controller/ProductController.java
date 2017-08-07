package ua.ali_x.controller;

import ua.ali_x.Service.ProductService;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class ProductController implements Controller {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        Integer idCategory = Integer.parseInt((String) vm.getAttribute("c_id"));
        Integer idProduct = Integer.parseInt((String) vm.getAttribute("p_id"));
        vm.setAttribute("product", productService.getProduct(idCategory, idProduct));
        vm.setView("product");
        return vm;
    }
}
