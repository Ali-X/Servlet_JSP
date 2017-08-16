package ua.ali_x.controller;

import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class LoginPageController implements Controller {
    @Override
    public ViewModel process(Request request) {
        vm.setView("login");
        return vm;
    }
}
