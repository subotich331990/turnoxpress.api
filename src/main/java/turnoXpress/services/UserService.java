package turnoXpress.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import turnoXpress.dtos.LoginRequest;
import turnoXpress.dtos.RegisterRequest;
import turnoXpress.entities.Patient;
import turnoXpress.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));

        GrantedAuthority permission = new SimpleGrantedAuthority("ROLE_" + patient.getRole().toString());

        List<GrantedAuthority> permissions = new ArrayList<>();
        permissions.add(permission);

        return new User(email, patient.getPassword(), permissions);
    }


    @Transactional
    public void createPatient(RegisterRequest registerRequest) throws Exception {
        Patient patient = new Patient(registerRequest.getName(), registerRequest.getEmail(), registerRequest.getPassword());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // no la declaro como global y autowired porque tira error
        if (patient.getName().isEmpty()) {
            throw new Exception("el nombre no puede estar vacio");
        }
        if (patient.getEmail().isEmpty()) {
            throw new Exception("el nombre no puede estar vacio");
        }
        if (patient.getPassword().isEmpty()) {
            throw new Exception("el nombre no puede estar vacio");
        }
        String encriptedPass = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encriptedPass); // antes de guardar el paciente en la base de datos encripto la pass
     //   patient.setRole(registerRequest.getRole());
        userRepository.save(patient);
    }
    @Transactional
    public boolean authenticateUser(LoginRequest loginRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // no la declaro como global y autowired porque tira error
        // Buscar el usuario por su dirección de correo electrónico
        Optional<Patient> optionalPatient = userRepository.findByEmail(loginRequest.getEmail());
        if(optionalPatient.isPresent()){
        Patient patient = optionalPatient.get();
        return passwordEncoder.matches(loginRequest.getPassword(), patient.getPassword());
        }
        // Verificar si se encontró un usuario y si las contraseñas coinciden
        return false;
    }

    @Transactional
    public void switchUser(Long userId) throws Exception {
        // Verifica si el usuario existe antes de actualizar
        Optional<Patient> optionalPatient = userRepository.findById(userId);
        if (optionalPatient.isPresent()) {
            Patient updatedPatient = optionalPatient.get();
            updatedPatient.setId(userId);  // Asegura que el ID del usuario se mantenga
            if (updatedPatient.getActive()) {
                updatedPatient.setActive(!updatedPatient.getActive());
                userRepository.save(updatedPatient);
            }
            throw new Exception("no se pudo actualizar"); // Manejo de errores: usuario no encontrado
        }
        throw new Exception("no se pudo actualizar"); // Manejo de errores: usuario no encontrado
    }


    public List<Patient> getAllPatients() {
        return userRepository.findAll();
    }

    public Patient getPatientById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public Patient updatePatient(Long userId, Patient updatedPatient) throws Exception {
        // Verifica si el usuario existe antes de actualizar
        if (!userRepository.existsById(userId)) {
            throw new Exception("El usuario no existe");
        } else {
            updatedPatient.setId(userId);  // Asegura que el ID del usuario se mantenga
            return userRepository.save(updatedPatient);
        }
    }

}
