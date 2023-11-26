package turnoXpress.services;



public interface AuthService {
    boolean autenticar(Long id, String password);
}