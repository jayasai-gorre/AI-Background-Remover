package in.jayasaigorre.remove.bg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations to reduce boilerplate:
// @Data generates getters, setters, toString, equals, and hashCode methods
// @AllArgsConstructor generates constructor with all fields
// @NoArgsConstructor generates default constructor
// @Builder enables the builder pattern for easy object creation
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    // Data Transfer Object (DTO) is used to transfer data between layers (e.g., Controller -> Service)
    // Similar to how in MERN you define a JSON schema for data transfer in API requests/responses

    private String clerkId;   // Unique user identifier, like _id or a custom user ID in MongoDB
    private String email;     // User email
    private String firstName; // User's first name
    private String lastName;  // User's last name
    private String photoUrl;  // URL of user profile picture
    private Integer credits;  // Number of credits or points the user has, like a numeric field in a MongoDB document
}
