package org.hibernate.backend.clinicaodontologicaspringhibernate.exceptions;

import lombok.Data;

@Data
public class PacienteNotFoundException extends RuntimeException{

    private Long id;

    public PacienteNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
