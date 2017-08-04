package ua.ali_x.controller;

import ua.ali_x.Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryController extends AbstractController {

    private ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idCategory = Integer.parseInt(request.getParameter("c_id"));
            request.setAttribute("products", productService.getAll(idCategory));
            request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/root/profile").forward(request, response);
        }
    }
}
