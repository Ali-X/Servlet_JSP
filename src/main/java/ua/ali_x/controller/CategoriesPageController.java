package ua.ali_x.controller;

import ua.ali_x.Service.CategoryService;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class CategoriesPageController implements Controller {

    private CategoryService categoryService;

    public CategoriesPageController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        vm.setAttribute("categories", categoryService.getAll());
        vm.setView("categories");
        return vm;
    }
}
