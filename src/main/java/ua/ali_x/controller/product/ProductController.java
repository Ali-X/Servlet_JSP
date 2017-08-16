package ua.ali_x.controller.product;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class ProductController implements Controller {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer idCategory = Integer.parseInt(request.getAttribute("c_id"));
        Integer idProduct = Integer.parseInt(request.getAttribute("p_id"));
        vm.setAttribute("product", productService.getProduct(idCategory, idProduct));
        vm.setView("product");
        return vm;
    }
}
