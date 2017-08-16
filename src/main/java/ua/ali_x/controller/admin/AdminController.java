package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class AdminController implements Controller {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        vm.setView("admin");
        return vm;
    }
}
