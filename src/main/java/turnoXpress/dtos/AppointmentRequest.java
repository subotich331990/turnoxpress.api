package turnoXpress.dtos;

import turnoXpress.entities.Medic;
import turnoXpress.entities.Patient;

import java.time.LocalDate;

public class AppointmentRequest {
    private String patient;
    private String medic;
    private String date;
    private String time;
    private String status;
    private String hospital;

    public AppointmentRequest() {
    }
    public AppointmentRequest(String speciality, String medic, String date, String time, String status, String hospital) {
        this.speciality = speciality;
        this.medic = medic;
        this.date = date;
        this.time = time;
        this.status = status;
        this.hospital = hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String patient) {
        this.speciality = speciality;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
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
}
