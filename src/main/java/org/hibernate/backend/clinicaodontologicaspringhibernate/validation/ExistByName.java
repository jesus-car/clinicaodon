package org.hibernate.backend.clinicaodontologicaspringhibernate.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.IEmployeeService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistByNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistByName {

    String message() default "El nombre ya existe en la base de datos";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<? extends IEmployeeService> entityService();
}
