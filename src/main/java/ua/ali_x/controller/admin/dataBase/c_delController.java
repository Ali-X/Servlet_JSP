package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.CategoryService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class c_delController implements Controller {
    private final CategoryService categoryService;

    public c_delController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer id = Integer.parseInt(request.getAttribute("c_id"));
        categoryService.delete(id);
        vm.setView("success");
        return vm;
    }
}
