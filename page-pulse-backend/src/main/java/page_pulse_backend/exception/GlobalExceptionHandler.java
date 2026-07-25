package page_pulse_backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle custom AuditException
    @ExceptionHandler(AuditException.class)
    public ResponseEntity<Map<String, Object>> handleAuditException(AuditException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle @Valid validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("success", false);

        FieldError fieldError = ex.getBindingResult().getFieldError();

        if (fieldError != null) {
            response.put("message", fieldError.getDefaultMessage());
        } else {
            response.put("message", "Validation failed.");
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle all unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("success", false);
        response.put("message", "Something went wrong. Please try again.");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}