package myproject.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

    @GetMapping("/user")
    public void userAction() {
        System.out.println("User");
    }
    @GetMapping("/admin")
    public void adminAction() {
        System.out.println("Admin");
    }

    @Secured("ROLE_USER")
    @GetMapping("/admin/method")
    public void adminMethodAction() {
        System.out.println("Admin method");
    }
}
