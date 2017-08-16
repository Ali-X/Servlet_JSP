package ua.ali_x.controller;

import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class HomePageController implements Controller {

    @Override
    public ViewModel process(Request request) {
        vm.setView("home");
        return vm;
    }
}
