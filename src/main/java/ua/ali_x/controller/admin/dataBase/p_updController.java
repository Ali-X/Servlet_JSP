package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class p_updController implements Controller {
    private final ProductService productService;

    public p_updController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer id = Integer.parseInt(request.getAttribute("id"));
        String new_name = request.getAttribute("new_p_name");
        String descr = request.getAttribute("p_descr");
        String c_name = request.getAttribute("c_name");
        productService.update(id, new_name, descr, c_name);
        vm.setView("success");
        return vm;
    }
}
