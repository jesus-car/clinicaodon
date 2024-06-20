package org.hibernate.backend.clinicaodontologicaspringhibernate.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PacienteEqualEmailException extends RuntimeException{
    private String email;

    public PacienteEqualEmailException(String message, String email) {
        super(message);
        this.email = email;
    }
}
