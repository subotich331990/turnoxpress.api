package turnoXpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import turnoXpress.entities.Patient;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Patient, Long> {

    @Query
    Optional<Patient> findByEmail(String email);


}
    /*
    @Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<Patient> findByName(@Param("name") String name);

    @Query("SELECT u FROM users u WHERE u.id = :id")
    Optional<User> findByID(@Param("id") Long id);
    */
