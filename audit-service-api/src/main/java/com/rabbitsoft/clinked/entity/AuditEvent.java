package com.rabbitsoft.clinked.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditEvent {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36)
    private String id;

    /**
     * Mnemonic style name for an audit event.
     */
    @Column(length = 32)
    @NotNull
    private String event;

    /**
     * Date the audit record was created.
     */
    @Column
    @NotNull
    private LocalDateTime dateCreated;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private User user;


}
