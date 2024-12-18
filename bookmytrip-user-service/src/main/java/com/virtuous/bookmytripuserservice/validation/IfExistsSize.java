package com.virtuous.bookmytripuserservice.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IfExistsSizeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IfExistsSize {
    String message() default "Invalid size: must match the required size if present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int size();
}
