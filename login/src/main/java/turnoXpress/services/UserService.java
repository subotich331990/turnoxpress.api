package turnoXpress.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import turnoXpress.entities.User;
import turnoXpress.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createUser(User user) throws Exception {
        if (user.getName().isEmpty()) {
            throw new Exception("el nombre no puede estar vacio");
        }
        userRepository.save(user);
        return user;
    }


    public User updateUser(Long userId, User updatedUser) throws Exception {
        // Verifica si el usuario existe antes de actualizar
        if (!userRepository.existsById(userId)) {
            throw new Exception("El usuario no existe");
        } else {
            updatedUser.setId(userId);  // Asegura que el ID del usuario se mantenga
            return userRepository.save(updatedUser);
        }
    }

    @Transactional
    public User switchUser(Long userId) throws Exception {
        // Verifica si el usuario existe antes de actualizar
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setId(userId);  // Asegura que el ID del usuario se mantenga
            if (updatedUser.getActive()) {
                updatedUser.setActive(!updatedUser.getActive());
                return userRepository.save(updatedUser);
            }
            throw new Exception("no se pudo actualizar"); // Manejo de errores: usuario no encontrado
        }
        throw new Exception("no se pudo actualizar"); // Manejo de errores: usuario no encontrado
    }

    @Transactional
    public boolean authenticateUser(String email, String password) {
        // Buscar el usuario por su dirección de correo electrónico
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
        User user = optionalUser.get();
        return passwordEncoder.matches(password, user.getPassword());
        }
        // Verificar si se encontró un usuario y si las contraseñas coinciden
        return false;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}