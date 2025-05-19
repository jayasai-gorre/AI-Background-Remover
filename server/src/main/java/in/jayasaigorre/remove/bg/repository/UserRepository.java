package in.jayasaigorre.remove.bg.repository;

import in.jayasaigorre.remove.bg.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository interface for UserEntity.
// Extends JpaRepository to provide CRUD operations and JPA functionality.
// The entity type is UserEntity and the primary key type is Long.
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Checks if a user exists with the given clerkId.
    // Returns true if a user with the specified clerkId exists, otherwise false.
    boolean existsByClerkId(String clerkId);

    // Retrieves a user by their clerkId.
    // Returns an Optional containing the UserEntity if found, or empty Optional if not.
    Optional<UserEntity> findByClerkId(String clerkId);
}
