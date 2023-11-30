package turnoXpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import turnoXpress.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM users u WHERE u.name = :name")
    Optional<User> findByName(@Param("name") String name);

    @Query("SELECT u FROM users u WHERE u.id = :id")
    Optional<User> findByID(@Param("id") Long id);
}
