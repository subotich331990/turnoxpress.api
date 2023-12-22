package turnoXpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import turnoXpress.dtos.RegisterRequest;
import turnoXpress.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v2")
public class RegisterController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) throws Exception {
        userService.createPatient(registerRequest);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

}
     /*   try {
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear usuario");
        } */
