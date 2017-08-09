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
    private Map<Request, Controller> controllerMap;

    public void init() {
        controllerMap = Factory.getControllerMap();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
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
            throw new RuntimeException("The error is " + e);
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