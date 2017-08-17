package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.model.Product;
import ua.ali_x.service.CategoryService;
import ua.ali_x.service.ProductService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import java.util.List;

public class ProductSettingsViewController implements Controller {
    private final ProductService productService;
    CategoryService categoryService;

    public ProductSettingsViewController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {

        int page = 1;
        int recordsPerPage = 5;
        if (request.getAttribute("page") != null)
            page = Integer.parseInt(request.getAttribute("page"));
        List<Product> list = productService.getAll();
        List<Product> sublist = list.subList((page - 1) * recordsPerPage,
                recordsPerPage);
        int noOfRecords = list.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        vm.setAttribute("employeeList", list);
        vm.setAttribute("noOfPages", noOfPages);
        vm.setAttribute("currentPage", page);
        vm.setAttribute("categories", categoryService.getAll());
        vm.setAttribute("products", productService.getAll());
        vm.setView("adminProduct");
        return vm;
    }
}
