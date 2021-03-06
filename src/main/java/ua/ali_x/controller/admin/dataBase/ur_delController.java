package ua.ali_x.controller.admin.dataBase;

import ua.ali_x.controller.Controller;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

public class ur_delController implements Controller {

    private final UserService userService;

    public ur_delController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer id = Integer.parseInt(request.getAttribute("u_id"));
        String roleName = request.getAttribute("ur_name");
        userService.delRole(id, roleName);
        vm.setView("success");
        return vm;
    }
}
