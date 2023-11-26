package turnoXpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import turnoXpress.services.AuthService;
import turnoXpress.services.AuthServiceImpl;

@Controller
public class LoginController {

    @Autowired
    private AuthServiceImpl authService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarFormularioLogin(@RequestParam Long id, @RequestParam String password) {
        if (authService.autenticar(id, password)) {
            return "redirect:/inicio";
        } else {
            return "redirect:/login?error";
        }
    }
}
