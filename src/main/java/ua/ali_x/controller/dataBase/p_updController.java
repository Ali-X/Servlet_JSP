package ua.ali_x.controller.dataBase;

import ua.ali_x.Service.ProductService;
import ua.ali_x.controller.Controller;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class p_updController implements Controller {
    private ProductService productService;

    public p_updController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String old_name = (String) vm.getAttribute("old_p_name");
        String new_name = (String) vm.getAttribute("new_p_name");
        String descr = (String) vm.getAttribute("p_descr");
        String c_name = (String) vm.getAttribute("c_name");
        productService.update(old_name, new_name, descr, c_name);
        vm.setView("success");
        return vm;
    }
}
