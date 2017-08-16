package ua.ali_x.controller.user;

import ua.ali_x.controller.Controller;
import ua.ali_x.model.Roles;
import ua.ali_x.model.User;
import ua.ali_x.service.CategoryService;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import javax.servlet.http.Cookie;

public class GetUserController implements Controller {

    private final UserService userService;
    private final CategoryService categoryService;

    public GetUserController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request) {
        String userName = request.getAttribute("userName");
        String pass = request.getAttribute("password");
        User user = userService.findUser(userName, pass);
        if (user != null) {
            vm.setAttribute("user", user);
            vm.setCookie(new Cookie("token", user.getToken()));
            if (user.getRoles().contains(Roles.ADMIN)) {
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
