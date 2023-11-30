package turnoXpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnoXpress.entities.User;
import turnoXpress.repositories.UserRepository;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    public boolean autenticar(Long id, String password) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user != null && user.getClass().equals(password);
        } else {
            return true;
        }

        // Verificar si el usuario existe y la contraseña es correcta

    }
}
