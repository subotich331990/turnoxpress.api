package turnoXpress.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "medics")
public class Medic implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "email")
    private String email;

    // Otros campos relevantes para la información del médico.

    public Medic(String nombre, String apellido, String especialidad, String email) {
        this.name = nombre;
        this.lastName = apellido;
        this.specialty = especialidad;
        this.email = email;
        // Inicializa otros campos según sea necesario.
    }

    // Constructor sin parámetros (necesario para JPA).
    public Medic() {
    }

    // Métodos getter y setter...

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String apellido) {
        this.lastName = apellido;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String especialidad) {
        this.specialty = especialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }
// Otros métodos getter y setter según sea necesario.
}
