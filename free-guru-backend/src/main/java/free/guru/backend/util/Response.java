package free.guru.backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response {
    public static ResponseEntity<?> getResponse(HttpStatus httpStatus, Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", httpStatus.value());
        response.put("status", httpStatus.getReasonPhrase());

        if (data != null) response.put("data", data);

        return ResponseEntity.status(httpStatus).body(response);
    }
}
