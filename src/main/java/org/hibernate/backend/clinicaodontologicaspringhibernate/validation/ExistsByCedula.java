package org.hibernate.backend.clinicaodontologicaspringhibernate.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsByCedulaValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByCedula {
    String message() default "Ya existe un usuario con esta cedula";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
