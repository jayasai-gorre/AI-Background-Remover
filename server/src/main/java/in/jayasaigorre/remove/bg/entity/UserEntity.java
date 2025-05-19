package in.jayasaigorre.remove.bg.entity;

// This class represents the User entity mapped to the 'tbl_users' table in the database.
// Equivalent to a Mongoose schema in MongoDB but here using JPA for relational DB.
// Lombok is used to reduce boilerplate code by auto-generating getters, setters, constructors, builder, etc.
// Jakarta Persistence API (JPA) annotations are used to define the entity and its mappings.

import jakarta.persistence.*;
import lombok.*;

@Entity  // Marks this class as a JPA entity mapped to a database table
@Table(name = "tbl_users")  // Specifies the table name in the database
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode
@AllArgsConstructor  // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor   // Lombok annotation to generate a no-argument constructor
@Builder  // Lombok annotation to implement the builder pattern for easy object creation
public class UserEntity {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates primary key values (auto-increment)
    private Long id;

    @Column(unique = true, nullable = false)  // Maps to a column which must be unique and not null
    private String clerkId;

    @Column(unique = true, nullable = false)  // Email must be unique and not null
    private String email;

    private String firstName;
    private String lastName;
    private Integer credits;
    private String photoUrl;

    // This method is called automatically before the entity is persisted (saved) in the database
    // It sets default credits to 5 if credits is null when a new user is created
    @PrePersist
    public void prePersist() {
        if (credits == null) {
            credits = 5;
        }
    }
}
