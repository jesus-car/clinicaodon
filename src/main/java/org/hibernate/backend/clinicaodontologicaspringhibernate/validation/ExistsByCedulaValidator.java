package org.hibernate.backend.clinicaodontologicaspringhibernate.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistsByCedulaValidator implements ConstraintValidator<ExistsByCedula,Integer> {

    @Autowired
    private PacienteService pacienteService;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(pacienteService == null){
            return true;
        }
        return !pacienteService.existePorCedula(value);
    }
}
