package org.hibernate.backend.clinicaodontologicaspringhibernate.exceptions;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.ClinicaExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ClinicaExceptions {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ClinicaExceptionEntity> exceptionHandler(NoResourceFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClinicaExceptionEntity(e.getMessage(), "Recurso no encontrado"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ClinicaExceptionEntity> exceptionHandler(Exception e){
        return ResponseEntity.badRequest().body(new ClinicaExceptionEntity(e.getMessage(), "Error en los datos ingresados"));
    }

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<ClinicaExceptionEntity> exceptionHandler(PacienteNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new ClinicaExceptionEntity(e.getMessage(), "El paciente con id "+ e.getId() + e.getMessage()));
    }

    @ExceptionHandler(PacienteEqualEmailException.class)
    public ResponseEntity<ClinicaExceptionEntity> exceptionHandler(PacienteEqualEmailException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new ClinicaExceptionEntity(e.getMessage(), "El email "+ e.getEmail() + " ya se encuentra registrado"));
    }
}
