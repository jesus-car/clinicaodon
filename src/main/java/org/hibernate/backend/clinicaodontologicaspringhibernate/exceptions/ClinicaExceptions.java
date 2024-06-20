package org.hibernate.backend.clinicaodontologicaspringhibernate.exceptions;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.ClinicaExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

 @RestControllerAdvice
public class ClinicaExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ClinicaExceptionEntity> exceptionHandler(Exception e){
        return ResponseEntity.badRequest().body(new ClinicaExceptionEntity(e.getMessage(), "Error en los datos ingresados"));
    }

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<ClinicaExceptionEntity> exceptionHandler(PacienteNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new ClinicaExceptionEntity(e.getMessage(), "El paciente con id "+ e.getId() +" ingresado no existe"));
    }
}
