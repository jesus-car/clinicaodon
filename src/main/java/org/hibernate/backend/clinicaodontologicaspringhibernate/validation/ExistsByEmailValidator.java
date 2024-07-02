package org.hibernate.backend.clinicaodontologicaspringhibernate.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistsByEmailValidator implements ConstraintValidator<ExistsByEmail, String> {

    @Autowired
    private PacienteService pacienteService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (pacienteService == null) {
            return true;
        }
        return !pacienteService.existePorEmail(value);
    }
}
