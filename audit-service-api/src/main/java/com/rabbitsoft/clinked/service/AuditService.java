package com.rabbitsoft.clinked.service;

import com.rabbitsoft.clinked.aspect.AuditTrail;
import com.rabbitsoft.clinked.entity.AuditEvent;
import com.rabbitsoft.clinked.repository.AuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRepository auditRepository;

    @AuditTrail
    public AuditEvent save(AuditEvent auditEvent) {
//        AuditEvent auditEvent = AuditEvent.builder()
//                .event("TEST_EVENT")
//                .dateCreated(LocalDateTime.now())
//                .user(User.builder().username("ahmetburak").build())
//                .build();
        return auditRepository.save(auditEvent);
    }

    public List<AuditEvent> findByUserName(String username) {
        //todo! there should be mapstruct, and AuditEventDTO must be return instead of Audit Event entity
        return auditRepository.findByUserName(username);
    }


}
