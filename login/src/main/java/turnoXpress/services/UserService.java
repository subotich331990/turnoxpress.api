package turnoXpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnoXpress.entities.User;
import turnoXpress.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void createUser(User user) {
        // Puedes agregar validaciones u lógica de negocio aquí antes de guardar
        userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        // Verifica si el usuario existe antes de actualizar
        if (userRepository.existsById(userId)) {
            updatedUser.setId(userId);  // Asegura que el ID del usuario se mantenga
            return userRepository.save(updatedUser);
        }
        return null; // Manejo de errores: usuario no encontrado
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

