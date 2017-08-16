package ua.ali_x.controller.category;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.CategoryService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class CategoriesPageController implements Controller {

    private final CategoryService categoryService;

    public CategoriesPageController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        vm.setAttribute("categories", categoryService.getAll());
        vm.setView("categories");
        return vm;
    }
}
