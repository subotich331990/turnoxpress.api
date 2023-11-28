package turnoXpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import turnoXpress.services.UserService;

@Controller
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService us;
    @PostMapping("/create")
    public String createUser() {
        return "/register";
    }
}
