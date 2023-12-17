package turnoXpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import turnoXpress.entities.Medic;

import java.util.Optional;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
    @Query("SELECT m FROM Medic m WHERE m.name = :name")
    Optional<Medic> findByName(@Param("name") String name);
}