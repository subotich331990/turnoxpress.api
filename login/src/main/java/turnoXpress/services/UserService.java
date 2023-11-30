package turnoXpress.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnoXpress.entities.User;
import turnoXpress.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Transactional
    public User createUser(User user) throws Exception {
        if (user.getName().isEmpty()) {
            throw new Exception("el nombre no puede estar vacio");
        }
        userRepository.save(user);
        return user;
    }
    @Transactional
    public User updateUser(Long userId, User updatedUser) {
        // Verifica si el usuario existe antes de actualizar
        if (userRepository.existsById(userId)) {
            updatedUser.setId(userId);  // Asegura que el ID del usuario se mantenga
            return userRepository.save(updatedUser);
        }
        return null; // Manejo de errores: usuario no encontrado
    }
    @Transactional
    public User switchUser(Long userId) {
// Verifica si el usuario existe antes de actualizar
            Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setId(userId);  // Asegura que el ID del usuario se mantenga
            updatedUser.setActive(!updatedUser.getActive());
            return userRepository.save(updatedUser);
        }
        return null; // Manejo de errores: usuario no encontrado
    }
}

