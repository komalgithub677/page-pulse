package page_pulse_backend.exception;

public class AuditException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuditException(String message) {
        super(message);
    }

    public AuditException(String message, Throwable cause) {
        super(message, cause);
    }
}