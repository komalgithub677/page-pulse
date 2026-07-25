package page_pulse_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import page_pulse_backend.dto.AuditResponse;
import page_pulse_backend.exception.AuditException;

public class AuditServiceTest {

    private final AuditService auditService = new AuditService();

    @Test
    void shouldThrowExceptionForInvalidUrl() {

        AuditException exception = assertThrows(
                AuditException.class,
                () -> auditService.auditPage("abc"));

        assertEquals(
                "Please enter a valid HTTP or HTTPS URL.",
                exception.getMessage());
    }

    @Test
    void shouldAuditExampleDotCom() {

        AuditResponse response =
                auditService.auditPage("https://example.com");

        assertEquals(200, response.getStatus());

        assertEquals("Example Domain", response.getTitle());

        assertTrue(response.getH1Count() > 0);

        assertTrue(response.getWordCount() > 0);
    }

    @Test
    void shouldThrowExceptionForUnknownWebsite() {

        AuditException exception = assertThrows(
                AuditException.class,
                () -> auditService.auditPage(
                        "https://abcxyz123456789.com"));

        assertNotNull(exception.getMessage());
    }
}