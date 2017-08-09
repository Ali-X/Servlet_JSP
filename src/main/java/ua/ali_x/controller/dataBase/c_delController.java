package ua.ali_x.controller.dataBase;

import ua.ali_x.Service.CategoryService;
import ua.ali_x.controller.Controller;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class c_delController implements Controller {
    private CategoryService categoryService;

    public c_delController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String name = (String) vm.getAttribute("c_name");
        categoryService.delete(name);
        vm.setView("success");
        return vm;
    }
}
