package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class p_delController implements Controller {
    private final ProductService productService;

    public p_delController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer id = Integer.parseInt(request.getAttribute("p_id"));
        productService.delete(id);
        vm.setView("success");
        return vm;
    }
}
