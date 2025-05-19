package in.jayasaigorre.remove.bg.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor  // Generates default no-args constructor
@Builder // Implements the builder pattern for easy object creation

public class RemoveBgResponse {
    private boolean success;        // Indicates whether the API call was successful (true/false)
    private HttpStatus statusCode;  // HTTP status code of the response (e.g. 200 OK, 403 Forbidden)
    private Object data;            // Payload of the response; can be any object (like JSON body)
}
