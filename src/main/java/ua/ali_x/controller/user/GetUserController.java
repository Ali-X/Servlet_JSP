package ua.ali_x.controller.user;

import ua.ali_x.controller.Controller;
import ua.ali_x.model.Roles;
import ua.ali_x.model.User;
import ua.ali_x.service.UserService;
import ua.ali_x.servlet.Request;
import ua.ali_x.servlet.ViewModel;

import javax.servlet.http.Cookie;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetUserController implements Controller {

    private final UserService userService;

    public GetUserController(UserService userService) {
        this.userService = userService;
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
                Path currentRelativePath = Paths.get("images");
                String uploadPath = currentRelativePath.toAbsolutePath().toString();
                String fileName = user.getUserName() + ".png";
                String filePath = uploadPath + File.separator + fileName;
                vm.setAttribute("image", filePath);
                vm.setAttribute("user", user);
                vm.setView("userPage");
            }
        } else {
            vm.setView("login");
        }
        return vm;
    }
}
