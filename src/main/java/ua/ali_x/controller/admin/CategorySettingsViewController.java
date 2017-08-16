package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.CategoryService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class CategorySettingsViewController implements Controller {
    private final CategoryService categoryService;

    public CategorySettingsViewController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        vm.setAttribute("categories", categoryService.getAll());
        vm.setView("adminCategory");
        return vm;
    }
}
