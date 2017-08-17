package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class AdminController implements Controller {

    @Override
    public ViewModel process(Request request) {
        vm.setView("admin");
        return vm;
    }
}
