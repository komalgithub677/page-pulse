package page_pulse_backend.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import page_pulse_backend.dto.AuditRequest;
import page_pulse_backend.dto.AuditResponse;
import page_pulse_backend.service.AuditService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping("/audit")
    public ResponseEntity<AuditResponse> auditPage(
            @Valid @RequestBody AuditRequest request) {

        AuditResponse response =
                auditService.auditPage(request.getUrl());

        return ResponseEntity.ok(response);
    }
}
