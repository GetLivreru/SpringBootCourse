package com.example.Project2.validators;


import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = CurrentYearValidator.class)
@Documented
public @interface CurrentYear {
    String message() default "Год не может быть больше текущего";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

