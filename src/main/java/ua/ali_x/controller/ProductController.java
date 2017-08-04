package ua.ali_x.controller;

import ua.ali_x.Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends AbstractController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idCategory = Integer.parseInt(request.getParameter("c_id"));
            Integer idProduct = Integer.parseInt(request.getParameter("p_id"));
            request.setAttribute("product", productService.getProduct(idCategory, idProduct));
            request.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/root/profile").forward(request, response);
        }
    }

}
