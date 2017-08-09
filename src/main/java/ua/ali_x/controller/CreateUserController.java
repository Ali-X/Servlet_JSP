package ua.ali_x.controller;

import ua.ali_x.Model.Roles;
import ua.ali_x.Model.User;
import ua.ali_x.Service.CategoryService;
import ua.ali_x.Service.UserService;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import javax.servlet.http.Cookie;

public class CreateUserController implements Controller {

    private UserService userService;
    private CategoryService categoryService;

    public CreateUserController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String userName = (String) vm.getAttribute("userName");
        String password = (String) vm.getAttribute("password");
        String email = (String) vm.getAttribute("email");
        String token = userName + System.nanoTime();
        User user = new User(null, userName, password, email, token, null );
        userService.create(user);
        vm.setAttribute("user", user);
        vm.setCookie(new Cookie("token", user.getToken()));
        if (user.getRoles().contains(Roles.ADMIN)) {
            vm.setView("admin");
        } else {
            vm.setView("categories");
            vm.setAttribute("categories", categoryService.getAll());
        }
        return vm;
    }
}
