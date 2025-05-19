package in.jayasaigorre.remove.bg.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.jayasaigorre.remove.bg.dto.UserDTO;
import in.jayasaigorre.remove.bg.response.RemoveBgResponse;
import in.jayasaigorre.remove.bg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.svix.Webhook;
import com.svix.exceptions.WebhookVerificationException;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/webhooks")
@RequiredArgsConstructor
public class ClerkWebHookController {

    @Value("${clerk.webhook.secret}")
    private String webhookSecret;

    private final UserService userService;

    @PostMapping("/clerk")
    public ResponseEntity<String> handleClerkWebhook(
            @RequestHeader("svix-id") String svixId,
            @RequestHeader("svix-timestamp") String svixTimestamp,
            @RequestHeader("svix-signature") String svixSignature,
            @RequestBody String payload) {
//            System.out.println("✅ Clerk webhook received!");
//            System.out.println("Headers: svix-id=" + svixId + ", timestamp=" + svixTimestamp + ", signature=" + svixSignature);
//            System.out.println("Payload: " + payload);

        RemoveBgResponse response = null;
            try {
                boolean isValid = verifyWebhookSignature(svixId, svixTimestamp, svixSignature, payload);

                if (!isValid) {
                    response =  RemoveBgResponse.builder()
                            .statusCode(HttpStatus.UNAUTHORIZED)
                            .data("Invalid Webhook Signature")
                            .success(false)
                            .build();

                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body(response.toString());
                }

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(payload);

                String eventType = rootNode.path("type").asText();
                switch (eventType) {
                    case "user.created":
                        handleUserCreated(rootNode.path("data"));
                        break;

                    case "user.updated":
                        handleUserUpdated(rootNode.path("data"));
                        break;

                    case "user.deleted":
                        handleUserDeleted(rootNode.path("data"));
                        break;
                }

                return ResponseEntity.ok().build();
            } catch (Exception e) {
                response = RemoveBgResponse.builder()
                                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .data("Something went wrong")
                                                .success(false)
                                                        .build();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(response.toString());
            }

    }

    private void handleUserDeleted(JsonNode data) {
        String clerkId = data.path("id").asText();
        userService.deleteUserByClerkId(clerkId);
    }

    private void handleUserUpdated(JsonNode data) {
        System.out.println("Data getting updated in the clerk webhook controller");
        String clerkId = data.get("id").asText();
        UserDTO existingUser = userService.getUserByClerkId(clerkId);

        existingUser.setEmail(data.path("email_addresses").path(0).path("email_address").asText());
        existingUser.setFirstName(data.path("first_name").asText());
        existingUser.setLastName(data.path("last_name").asText());
        existingUser.setPhotoUrl(data.path("image_url").asText());

        userService.saveUser(existingUser);
    }

    private void handleUserCreated(JsonNode data) {
        UserDTO newUser = UserDTO.builder()
                .clerkId(data.get("id").asText())
                .email(data.get("email_addresses").path(0).path("email_address").asText())
                .firstName(data.get("first_name").asText())
                .lastName(data.get("last_name").asText())
                .build();

        userService.saveUser(newUser);
    }

    private boolean verifyWebhookSignature(String svixId, String timestamp, String signature, String payload) {
        try {
            Webhook webhook = new Webhook(webhookSecret);

            // Build HttpHeaders from svix headers
            Map<String, List<String>> headersMap = new HashMap<>();
            headersMap.put("svix-id", List.of(svixId));
            headersMap.put("svix-timestamp", List.of(timestamp));
            headersMap.put("svix-signature", List.of(signature));

            HttpHeaders headers = HttpHeaders.of(headersMap, (k, v) -> true);

            webhook.verify(payload, headers); // throws if invalid
            return true;
        } catch (WebhookVerificationException e) {
            System.out.println("Webhook verification failed: " + e.getMessage());
            return false;
        }

        // return true;
    }
}
