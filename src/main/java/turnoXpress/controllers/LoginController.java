package turnoXpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import turnoXpress.dtos.LoginRequest;
import turnoXpress.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean authenticated = userService.authenticateUser(loginRequest);

        if (authenticated) {
            return ResponseEntity.ok("INICIO DE SESION EXITOSO");
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