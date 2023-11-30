package turnoXpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import turnoXpress.entities.User;
import turnoXpress.services.AuthServiceImpl;
import turnoXpress.services.UserService;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private AuthServiceImpl authService;
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {

        try {
            userService.createUser(user);
            model.addAttribute("exito", "usuario_creado");
            return "/register";

        } catch (Exception e) {
            model.addAttribute("error", "usuario_no_creado");
            return "/register";
        }
    }


    /* @PostMapping("/register")
    public void procesarFormularioRegister(@RequestParam Long id, @RequestParam String password) {
        if (authService.autenticar(id, password)) {
            return "redirect:/inicio";
        } else {
            return "redirect:/register?error";
        }
    } */
}
