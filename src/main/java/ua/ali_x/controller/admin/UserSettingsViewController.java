package ua.ali_x.controller.admin;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class UserSettingsViewController implements Controller {

    private final UserService userService;

    public UserSettingsViewController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        vm.setAttribute("users", userService.getAll());
        vm.setAttribute("userWithRoles", userService.getRoles());
        vm.setAttribute("allRoles", userService.getAllRoles());
        vm.setView("adminUser");
        return vm;
    }
}
