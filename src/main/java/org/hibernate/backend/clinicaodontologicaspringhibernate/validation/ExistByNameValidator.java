package org.hibernate.backend.clinicaodontologicaspringhibernate.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ExistByNameValidator implements ConstraintValidator<ExistByName, String> {

    @Autowired
    private ApplicationContext applicationContext;

    private IEmployeeService entityService;

    @Override
    public void initialize(ExistByName constraintAnnotation) {
        if (applicationContext == null) {
            return;
        }
        Class<? extends IEmployeeService> serviceClass = constraintAnnotation.entityService();
        this.entityService = applicationContext.getBean(serviceClass);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (entityService == null) {
            return true;
        }

        if(value == null || value.isEmpty()){
            return true;
        }
        return !entityService.existePorNombre(value);
    }
}
