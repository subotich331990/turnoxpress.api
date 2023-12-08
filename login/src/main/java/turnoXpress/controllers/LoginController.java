package turnoXpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import turnoXpress.entities.User;
import turnoXpress.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Usuario creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear usuario");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        // Implementa la lógica de autenticación aquí (puede ser usando Spring Security)
        boolean authenticated = userService.authenticateUser(email, password);

        if (authenticated) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable Long userId) {
        try {
            userService.switchUser(userId);
            return ResponseEntity.ok("Usuario inactivado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}









    /* Spring MVC
    @GetMapping("/register")
    public String showRegister(Model model) {
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
    @GetMapping("/delete")
    public String showDelete(Model model) {
        model.addAttribute("user", new User());
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(User user, Model model) {

        try {
            userService.switchUser(user.getId());
            model.addAttribute("exito", "user_deleted");
            return "/delete";

        } catch (Exception e) {
            model.addAttribute("error", "user_not_found");
            return "/delete";
        }
    }

    */


