package in.jayasaigorre.remove.bg.service.impl;

import in.jayasaigorre.remove.bg.dto.UserDTO;
import in.jayasaigorre.remove.bg.entity.UserEntity;
import in.jayasaigorre.remove.bg.repository.UserRepository;
import in.jayasaigorre.remove.bg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Marks this class as a Spring-managed service component (like a Service layer in MERN)
@RequiredArgsConstructor // Lombok generates constructor for final fields for dependency injection

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; // Injects UserRepository for DB access (like a Mongoose model)

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        // Check if a user already exists with the given clerkId (external user ID)
        Optional<UserEntity> optionalUser = userRepository.findByClerkId(userDTO.getClerkId());

        if (optionalUser.isPresent()) {
            // User exists: update the fields from incoming DTO
            UserEntity existingUser = optionalUser.get();

            existingUser.setEmail(userDTO.getEmail());
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setPhotoUrl(userDTO.getPhotoUrl());

            // Only update credits if it's explicitly provided (to avoid overwriting unintentionally)
            if (userDTO.getCredits() != null) {
                existingUser.setCredits(userDTO.getCredits());
            }

            // Save the updated user entity back to the database
            existingUser = userRepository.save(existingUser);

            // Convert entity back to DTO to return
            return mapToDTO(existingUser);
        }

        // User does not exist, so create a new one by mapping DTO to Entity
        UserEntity newUser = mapToEntity(userDTO);
        userRepository.save(newUser);

        return mapToDTO(newUser);
    }

    @Override
    public UserDTO getUserByClerkId(String clerkId) {
        UserEntity userEntity = userRepository.findByClerkId(clerkId)
                .orElseThrow(() -> new UsernameNotFoundException("User with clerkId " + clerkId + " not found"));

        return mapToDTO(userEntity);
    }

    @Override
    public void deleteUserByClerkId(String clerkId) {
        UserEntity userEntity = userRepository.findByClerkId(clerkId)
                .orElseThrow(() -> new UsernameNotFoundException("User with clerkId " + clerkId + " not found"));

        userRepository.delete(userEntity);
    }

    // Helper method: converts UserEntity (DB model) to UserDTO (response/transfer object)
    private UserDTO mapToDTO(UserEntity newUser) {
        return UserDTO.builder()
                .clerkId(newUser.getClerkId())
                .credits(newUser.getCredits())
                .email(newUser.getEmail())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .photoUrl(newUser.getPhotoUrl())
                .build();
    }

    // Helper method: converts UserDTO (incoming request) to UserEntity (DB model)
    private UserEntity mapToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .clerkId(userDTO.getClerkId())
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .photoUrl(userDTO.getPhotoUrl())
                .build();
    }
}
