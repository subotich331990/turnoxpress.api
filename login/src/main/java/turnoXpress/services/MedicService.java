package turnoXpress.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnoXpress.entities.Medic;
import turnoXpress.repositories.MedicRepository;

import java.util.Optional;

@Service
public class MedicService {
    @Autowired
    private MedicRepository medicRepository;

    @Transactional
    public Medic createMedic(Medic medic) throws Exception {
        if (medic.getName().isEmpty() || medic.getSpecialty().isEmpty()) {
            throw new Exception("El nombre y la especialidad del médico no pueden estar vacíos");
        }
        medicRepository.save(medic);
        return medic;
    }

    public Medic updateMedic(Long medicId, Medic updatedMedic) throws Exception {
        // Verifica si el médico existe antes de actualizar
        if (!medicRepository.existsById(medicId)) {
            throw new Exception("El médico no existe");
        } else {
            updatedMedic.setId(medicId);  // Asegura que el ID del médico se mantenga
            return medicRepository.save(updatedMedic);
        }
    }

    @Transactional
    public Medic toggleMedicStatus(Long medicId) throws Exception {
        Optional<Medic> optionalMedic = medicRepository.findById(medicId);

        // Verifica si el médico existe antes de actualizar
        if (optionalMedic.isPresent()) {
            Medic updatedMedic = optionalMedic.get();
            updatedMedic.setId(medicId);  // Asegura que el ID del médico se mantenga
            // Realiza la lógica para cambiar el estado del médico (activo/inactivo)
            // Por ejemplo, puedes tener un campo en la entidad Medic para el estado.
            // updatedMedic.setActive(!updatedMedic.getActive());
            return medicRepository.save(updatedMedic);
        }
        throw new Exception("No se pudo actualizar el estado del médico"); // Manejo de errores: médico no encontrado
    }
}
