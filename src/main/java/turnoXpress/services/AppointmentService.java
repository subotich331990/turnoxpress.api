package turnoXpress.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnoXpress.dtos.AppointmentRequest;
import turnoXpress.entities.Appointment;
import turnoXpress.repositories.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public void createAppointment(AppointmentRequest appointmentRequest){
        Appointment appointment = new Appointment(appointmentRequest.getSpeciality(), appointmentRequest.getMedic(), appointmentRequest.getDate(), appointmentRequest.getTime(), appointmentRequest.getStatus(), appointmentRequest.getHospital());
        appointmentRepository.save(appointment);
    }
    public ArrayList<Appointment> retriveAppointments() {

        return (ArrayList<Appointment>)appointmentRepository.findAll();
       //return List<AppointmentRequest> = appointmentRepository.findAll();
    }

}
