package ua.ali_x.controller.category;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class CategoryController implements Controller {

    private final ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer idCategory = Integer.parseInt(request.getAttribute("c_id"));
        vm.setAttribute("products", productService.getAll(idCategory));
        vm.setView("category");
        return vm;
    }
}
