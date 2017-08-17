package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.model.Category;
import ua.ali_x.service.CategoryService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import java.util.List;

public class CategorySettingsViewController implements Controller {
    private final CategoryService categoryService;

    public CategorySettingsViewController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {

        int page = 1;
        int recordsPerPage = 5;
        int temp;
        if (request.getAttribute("page") != null)
            page = Integer.parseInt(request.getAttribute("page"));
        List<Category> list = categoryService.getAll();
        List<Category> sublist;
        temp = page * recordsPerPage;
        int noOfRecords = list.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        if (temp < noOfRecords) {
            sublist = list.subList(temp - recordsPerPage, temp);
        } else {
            sublist = list.subList(temp - recordsPerPage, noOfRecords);
        }
        vm.setAttribute("noOfPages", noOfPages);
        vm.setAttribute("currentPage", page);

        vm.setAttribute("categories", sublist);
        vm.setView("adminCategory");
        return vm;
    }
}
