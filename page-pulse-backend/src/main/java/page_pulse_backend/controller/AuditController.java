package page_pulse_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import page_pulse_backend.dto.AuditRequest;
import page_pulse_backend.dto.AuditResponse;
import page_pulse_backend.service.AuditService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/audit")
    public AuditResponse auditWebsite(
            @Validated @RequestBody AuditRequest request) {

        return auditService.auditWebsite(request.getUrl());
    }
}