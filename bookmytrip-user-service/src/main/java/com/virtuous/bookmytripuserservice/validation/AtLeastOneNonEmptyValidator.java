package com.virtuous.bookmytripuserservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

public class AtLeastOneNonEmptyValidator implements ConstraintValidator<AtLeastOneNonEmpty, Object> {

    private String[] fields;

    @Override
    public void initialize(AtLeastOneNonEmpty constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            for (String field : fields) {
                String fieldValue = BeanUtils.getProperty(value, field);
                if (fieldValue != null && !fieldValue.trim().isEmpty()) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
