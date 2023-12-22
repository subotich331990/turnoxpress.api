package turnoXpress.entities;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_app;
    @Column(name="speciality")
    private String speciality;
    @Column(name="medic")
    private String medic;
    @Column(name= "date")
    private String date;
    @Column(name= "time")
    private String time;
    @Column(name= "status")
    private String status;

    @Column(name="hospital")
    private String hospital;

    public Appointment() {
    }

    public Appointment(String speciality, String medic, String date, String time, String status, String hospital) {
        this.speciality = speciality;
        this.medic = medic;
        this.date = date;
        this.time = time;
        this.status = status;
        this.hospital = hospital;
    }
    public int getId_app() {
        return id_app;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
// Los getters y setters para id_user y medic no se deberian proporcionar públicamente
    // para limitar el acceso a estos atributos relacionados con otras entidades.
}