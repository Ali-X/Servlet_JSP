package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class u_delController implements Controller {

    private final UserService userService;

    public u_delController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer userid = Integer.parseInt(request.getAttribute("u_id"));
        userService.delete(userid);
        vm.setView("success");
        return vm;
    }
}
