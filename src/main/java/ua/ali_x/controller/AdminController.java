package ua.ali_x.controller;

import ua.ali_x.Service.UserService;
import ua.ali_x.factory.Factory;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class AdminController implements Controller {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        vm.setView("admin");
        return vm;
    }
}
