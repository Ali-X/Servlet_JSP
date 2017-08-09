package ua.ali_x.controller.dataBase;

import ua.ali_x.Service.ProductService;
import ua.ali_x.controller.Controller;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class p_addController implements Controller {
    private ProductService productService;

    public p_addController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String name = (String) vm.getAttribute("p_name");
        String descr = (String) vm.getAttribute("p_descr");
        String c_name = (String) vm.getAttribute("c_name");
        productService.create(name, descr, c_name);
        vm.setView("success");
        return vm;
    }
}
