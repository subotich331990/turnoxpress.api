package turnoXpress.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Appointment implements Serializable {

    @Id
    @GeneratedValue
    private int id_app;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_medic")
    private Medic medic;

    private LocalDate date;
    private String time;
    private String status;

    // Constructor y getters

    public Appointment() {
        // Constructor vacío necesario para JPA
    }

    public Appointment(User user, Medic medic, LocalDate date, String time, String status) {
        this.user = user;
        this.medic = medic;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId_app() {
        return id_app;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Los getters y setters para id_user y medic no se proporcionan públicamente
    // para limitar el acceso a estos atributos relacionados con otras entidades.
}