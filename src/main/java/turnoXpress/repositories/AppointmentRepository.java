package turnoXpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import turnoXpress.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
