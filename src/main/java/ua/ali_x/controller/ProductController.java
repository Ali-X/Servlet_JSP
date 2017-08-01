package ua.ali_x.controller;

import ua.ali_x.Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idCategory = (Long) request.getAttribute("c_id");
        request.setAttribute("products" , productService.getAll(idCategory));
        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
    }
}
