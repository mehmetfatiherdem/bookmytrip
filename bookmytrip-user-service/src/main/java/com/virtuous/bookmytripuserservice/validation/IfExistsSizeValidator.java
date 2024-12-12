package com.virtuous.bookmytripuserservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IfExistsSizeValidator implements ConstraintValidator<IfExistsSize, String> {

    private int size;

    @Override
    public void initialize(IfExistsSize constraintAnnotation) {
        this.size = constraintAnnotation.size();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return true;

        return value.length() == size;
    }
}
