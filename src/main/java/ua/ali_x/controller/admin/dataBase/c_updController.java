package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.CategoryService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class c_updController implements Controller {
    private final CategoryService categoryService;

    public c_updController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer id = Integer.parseInt(request.getAttribute("id"));
        String new_name = request.getAttribute("new_c_name");
        categoryService.update(id, new_name);
        vm.setView("success");
        return vm;
    }
}
