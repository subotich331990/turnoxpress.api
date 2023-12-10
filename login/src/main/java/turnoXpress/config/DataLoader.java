package turnoXpress.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import turnoXpress.entities.Patient;
import turnoXpress.services.UserService;

@Configuration
@Profile("dev")
public class DataLoader {

    @Bean
    public CommandLineRunner loadDefaultUser(UserService userService, PasswordEncoder passwordEncoder) {
        return arg -> {
            Patient patient = new Patient();
            patient.setEmail("user@mail.com");
            patient.setPassword(passwordEncoder.encode("pass"));
            patient.setRole(Patient.Role.ADMIN);
            userService.createPatient(patient);
        };
    }

}
