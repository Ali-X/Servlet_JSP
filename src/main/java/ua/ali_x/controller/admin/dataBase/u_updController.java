package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class u_updController implements Controller {
    private final UserService userService;

    public u_updController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer id = Integer.parseInt(request.getAttribute("id"));
        String userName = request.getAttribute("userName");
        String password = request.getAttribute("password");
        String email = request.getAttribute("email");

        userService.update(id, userName, password, email);
        vm.setView("success");
        return vm;
    }
}
