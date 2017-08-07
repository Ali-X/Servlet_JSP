package ua.ali_x.controller;

import ua.ali_x.Model.User;
import ua.ali_x.Service.CategoryService;
import ua.ali_x.Service.UserService;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import javax.servlet.http.Cookie;

public class GetUserController implements Controller {

    private UserService userService;
    private CategoryService categoryService;

    public GetUserController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String userName = (String) vm.getAttribute("userName");
        String pass = (String) vm.getAttribute("password");
        User user = userService.findUser(userName, pass);
        if (user != null) {
            vm.setAttribute("user", user);
            vm.setCookie(new Cookie("token", user.getToken()));
            if (user.isiAmAdmin()) {
                vm.setView("admin");
            } else {
                vm.setView("categories");
                vm.setAttribute("categories", categoryService.getAll());
            }
        } else {
            vm.setView("login");
        }
        return vm;
    }
}
