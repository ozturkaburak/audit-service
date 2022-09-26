package com.rabbitsoft.clinked.repository;

import com.rabbitsoft.clinked.entity.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditEvent, Long> {

    @Query("SELECT a FROM AuditEvent a WHERE FUNCTION('JSON_EXTRACT', a.user, '$.username') =:val")
    public List<AuditEvent> findByUserName(@Param("val") String val);

    public List<AuditEvent> findAllByEvent(String event);
}
