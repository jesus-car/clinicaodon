package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import lombok.Data;

@Data
public class ClinicaExceptionEntity {
    private String message;
    private String details;

    public ClinicaExceptionEntity(String message, String details) {
        this.message = message;
        this.details = details;
    }
}
