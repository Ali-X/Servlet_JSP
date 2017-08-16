package ua.ali_x.controller;

import ua.ali_x.model.Roles;
import ua.ali_x.model.User;
import ua.ali_x.service.CategoryService;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import javax.servlet.http.Cookie;

public class ProfileController implements Controller {

    private final UserService userService;
    private final CategoryService categoryService;

    public ProfileController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        String TOKEN = "token";
        String token = null;
        boolean iAmAdmin;

        Cookie cookie = vm.getCookie();

        if (cookie != null) {
            String name = cookie.getName().toLowerCase();
            if (TOKEN.equals(name)) {
                token = cookie.getValue();
                User user = userService.findByToken(token);
                vm.setAttribute("user", user);
                if (user.getRoles().contains(Roles.ADMIN)) {
                    vm.setView("admin");
                } else {
                    vm.setAttribute("categories", categoryService.getAll());
                    vm.setView("categories");
                }
            }
        } else {
            vm.setView("login");
        }
        return vm;
    }
}
