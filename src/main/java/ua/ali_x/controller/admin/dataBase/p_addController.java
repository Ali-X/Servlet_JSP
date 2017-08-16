package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class p_addController implements Controller {
    private final ProductService productService;

    public p_addController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        String name = request.getAttribute("p_name");
        String descr = request.getAttribute("p_descr");
        Integer c_id = Integer.parseInt(request.getAttribute("c_id"));
        productService.create(name, descr, c_id);
        vm.setView("success");
        return vm;
    }
}
