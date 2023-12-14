package turnoXpress.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import turnoXpress.dtos.RegisterRequest;
import turnoXpress.entities.Patient;
import turnoXpress.entities.Role;
import turnoXpress.services.UserService;

@Configuration
@Profile("dev")
public class DataLoader {

    @Bean
    public CommandLineRunner loadDefaultUser(UserService userService, PasswordEncoder passwordEncoder) {
        return arg -> {
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setEmail("user@mail.com");
            registerRequest.setPassword(passwordEncoder.encode("pass"));
            registerRequest.setRole(Role.ADMIN);
            userService.createPatient(registerRequest);
        };
    }

}
