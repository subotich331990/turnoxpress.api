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
        User user = userRepository.findById(id);

        // Verificar si el usuario existe y la contraseña es correcta
        return user != null && user.getClass().equals(password);
    }
}
