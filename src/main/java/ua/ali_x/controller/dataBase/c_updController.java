package ua.ali_x.controller.dataBase;

import ua.ali_x.Service.CategoryService;
import ua.ali_x.controller.Controller;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class c_updController implements Controller {
    private CategoryService categoryService;

    public c_updController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String old_name = (String) vm.getAttribute("old_c_name");
        String new_name = (String) vm.getAttribute("new_c_name");
        categoryService.update(old_name, new_name);
        vm.setView("success");
        return vm;
    }
}
