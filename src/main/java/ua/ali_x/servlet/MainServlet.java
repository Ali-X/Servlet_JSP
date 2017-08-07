package ua.ali_x.servlet;

import ua.ali_x.controller.*;
import ua.ali_x.factory.Factory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private GetUserController getUserController;
    private CategoriesPageController categoriesPageController;
    private CategoryController categoryController;
    private ProductController productController;
    private CreateUserController createUserController;
    private AdminController adminController;
    private HashMap<String, String> pages;
    private Map<Request, Controller> controllerMap;

    public void init() {
        getUserController = Factory.getUserController();
        categoriesPageController = Factory.getCategoriesPageController();
        categoryController = Factory.getCategoryController();
        productController = Factory.getProductController();
        createUserController = Factory.getCreateUserController();
        adminController = Factory.getAdminController();
        //     pages = Factory.getPages();
        controllerMap = Factory.getControllerMap();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        /*for (Map.Entry<String, String> page : pages.entrySet()) {
            if (request.getRequestURI().equals(page.getKey())) {
                switch (page.getKey()) {
                    case "/root/login":
                        adminController.process(request, response);
                        //не использовать много контроллеров, а использовать много сервисов в одном котнтроллере
                        categoriesPageController.process(request, response);
                        //в юзер добавить поле проверки на роль
                        getUserController.process(request, response);
                        break;
                    case "/root/registration":
                        createUserController.process(request, response);
                        categoriesPageController.process(request, response);
                        request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
                        break;
                }
            }
        }*/
    }

    private void processRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        getAttributes(httpRequest);
        Request request = new Request(httpRequest.getMethod(), httpRequest.getRequestURI());
        try {
            Controller controller = controllerMap.get(request);
            if (controller == null) {
                throw new RuntimeException("Can't handle " + request.getUri());
            }
            ViewModel vm = controller.process(request);
            Cookie cookie = vm.getCookie();
            if (cookie != null) {
                httpResponse.addCookie(cookie);
            }
            setAttributes(httpRequest);
            forward(httpRequest, httpResponse, vm);
        } catch (Throwable e) {
            new RuntimeException("The error is " + e);
            //      e.getStackTrace();
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, ViewModel vm) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(getView(vm));
        requestDispatcher.forward(request, response);
    }

    private String getView(ViewModel vm) {
        String prefix = "/WEB-INF/views/";
        String suffix = ".jsp";
        return prefix + vm.getView() + suffix;

    }

    private void getAttributes(HttpServletRequest request) {
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            String[] value = request.getParameterValues(name);
            Factory.getViewModel().setAttribute(name, value[0]);
        }
    }

    private void setAttributes(HttpServletRequest request) {
        Map<String, Object> model = Factory.getViewModel().getModel();
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
    }
}