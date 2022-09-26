package com.rabbitsoft.clinked.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
//@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -1088495567608373162L;

    /**
     * Max length for username, password and username.
     */
    public static final int MAX_LENGTH = 32;

    private String id;

    @NotNull
    @Size(max = MAX_LENGTH)
    private String username;

}
