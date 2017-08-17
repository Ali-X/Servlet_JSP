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
import java.util.HashSet;
import java.util.Set;

public class CreateUserController implements Controller {

    private final UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        String userName = request.getAttribute("userName");
        String password = request.getAttribute("password");
        String email = request.getAttribute("email");
        String token = userName + System.nanoTime();
        Set<Roles> role = new HashSet<Roles>();
        role.add(Roles.USER);
        User user = new User(null, userName, password, email, token, role);
        userService.create(user);
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
        return vm;
    }
}
