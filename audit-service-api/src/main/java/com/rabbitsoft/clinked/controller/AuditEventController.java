package com.rabbitsoft.clinked.controller;

import com.rabbitsoft.clinked.entity.AuditEvent;
import com.rabbitsoft.clinked.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuditEventController {

    private final AuditService auditService;

    @PostMapping
    public String save(@RequestBody AuditEvent auditEvent) {
        AuditEvent savedAuditEvent = auditService.save(auditEvent);
        return savedAuditEvent.getId();
    }

    @GetMapping("findByUserName")
    public List<AuditEvent> findByUserName(@RequestParam String filter) {
        return auditService.findByUserName(filter);
    }
}
