package com.shopping_cart.eshoppers.dto.myAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Objects;

/*
 ** 2024, July 17, Wednesday, 6:00 AM
 */
public class PasswordMatcherValidator implements ConstraintValidator<PasswordMatcher, Object> {
    private String firstField;
    private String secondField;
    private String message;


    @Override
    public void initialize(PasswordMatcher passwordMatcher) {
        firstField= passwordMatcher.first();
        secondField= passwordMatcher.second();
        message= passwordMatcher.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        boolean valid = true;

        try {
            final Object first = getObject(object, firstField);
            final Object second = getObject(object, secondField);
            valid = Objects.equals(first, second);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }

        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstField)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }

    private Object getObject(Object object, String field) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = object.getClass().getDeclaredField(field);
        declaredField.setAccessible(true);
        return declaredField.get(object);
    }
}
