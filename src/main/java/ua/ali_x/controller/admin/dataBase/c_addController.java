package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.CategoryService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class c_addController implements Controller {
    private final CategoryService categoryService;

    public c_addController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        String name = request.getAttribute("c_name");
        categoryService.create(name);
        vm.setView("success");
        return vm;
    }
}
